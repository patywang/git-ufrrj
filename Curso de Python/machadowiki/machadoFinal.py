import re
import os.path
from whoosh.analysis import  RegexTokenizer, LowercaseFilter, StopFilter, StandardAnalyzer
from whoosh.index import create_in
from whoosh.fields import Schema, TEXT
from whoosh.index import open_dir
from whoosh.qparser import QueryParser, MultifieldParser


def tratandoContest():
	with open("dataset/CONTENTS",encoding='cp1252') as file_object:
		texto = file_object.readlines()

	#expressões regulares:
	titulo =re.compile("[^:]*\w*\)") #melhorar como apanha o titulo -> ta horrível isso aqui
	tipo_nome_arq = re.compile("(\w+)/(\w+).txt") #romance/arquivo.txt -> dá p tirar categoria e nome do arquivo para encaixar no link
	ano = re.compile("\(([\w-]*)\)") #finalmente foi o/ regex é vida <3 -> aaaa aaaa-aaaa aaaa-aa o/

	arquivo = []

	for i in range(0,len(texto)):

		auxTipoNomeArq = tipo_nome_arq.search(texto[i])
		auxTitulo = titulo.search(texto[i])
		auxAno = ano.search(texto[i])

		if auxTipoNomeArq and auxTitulo and auxAno:

			url = "http://machado.mec.gov.br/images/stories/html/"+auxTipoNomeArq.group(1)+"/"+auxTipoNomeArq.group(2)+".htm"
			cat = auxTipoNomeArq.group(1)

			if cat != "romance" and cat != "poesia" and cat != "contos" and cat != "teatro":

				if cat == "critica":
					cat = "crítica"
				elif cat == "traducao":
					cat = "tradução"
				elif cat == "cronica":
					cat = "crônica"
				elif cat == "miscelanea":
					cat = "miscelânea"

			documento = {"arquivo": auxTipoNomeArq.group(0),"categoria": cat,"titulo": auxTitulo.group(0),"ano": auxAno.group(1),"url":url}
			arquivo.append(documento)

	return arquivo

def indexacao():

	aux = tratandoContest()
	
	for i in range(0,len(aux)):
		with open("dataset/"+aux[i]['arquivo'],encoding='cp1252') as file_object:
			texto = file_object.read()
			aux[i]['texto'] = texto
			
	analyzers = RegexTokenizer() | LowercaseFilter() | StopFilter(lang = 'pt')
	schema = Schema(arquivo=TEXT(stored = True),categoria=TEXT(analyzer=analyzers,stored = True),titulo=TEXT(stored = True),conteudo=TEXT(analyzer=analyzers, stored = True),ano=TEXT(stored = True),url=TEXT(stored=True))
			
	if not os.path.exists("whoosh_index"):
		os.mkdir("whoosh_index")
		ix = create_in("whoosh_index", schema)
		ix.close()
		print("criou index")

	print("esperando...")
	try:
		ix = open_dir("whoosh_index")
		writer = ix.writer()
		for i in range(0,len(aux)):
			writer.add_document(arquivo=aux[i]['arquivo'],categoria=aux[i]['categoria'],titulo=aux[i]['titulo'],conteudo=aux[i]['texto'],ano=aux[i]['ano'],url=aux[i]['url'])
		writer.commit()
		print("escreveu")
			
	finally:	
		ix.close()
	
				
def pergunta(frase):

	analyzer = RegexTokenizer() | LowercaseFilter() | StopFilter(lang = 'pt')

	aux = []
	i = 0;

	for question in analyzer(frase):
		aux.append(question.text)

	frase = " OR ".join(aux)

	return frase

def buscador(frase,multibox):
	
	questao = pergunta(frase);
	#print(questao)
	analyzers = RegexTokenizer() | LowercaseFilter() | StopFilter(lang = 'pt')
	schema = Schema(arquivo=TEXT(stored = True),categoria=TEXT(analyzer=analyzers,stored = True),titulo=TEXT(stored = True),conteudo=TEXT(analyzer=analyzers, stored = True),ano=TEXT(stored = True),url=TEXT(stored=True))
	
	if (len(multibox) >= 1):
		parser = MultifieldParser(multibox,schema)
	else:
		parser = QueryParser("conteudo", schema)

	myquery = parser.parse(questao)

	try:
		ix = open_dir("whoosh_index")
		searcher = ix.searcher()

		results = searcher.search(myquery,terms=True,limit = 200)
	finally:
		ix.close()
		
	return results

#indexacao()

