from flask import Flask, render_template,request,url_for,redirect
import machadoFinal as machadowiki

app = Flask(__name__)  
 
@app.route('/')
def home():
  return render_template('index.html')

@app.route('/buscar', methods=['GET','POST'])
def buscar():
	frase = request.form.get("buscador")
	multibox = request.form.getlist("machadoSelect")
	taMult = len(multibox)

	if frase:

		resultado = machadowiki.buscador(frase,multibox)
		tam = len(resultado)

	else:
		return render_template('index.html')
		

	return render_template("lista.html",resultado=resultado,frase=frase,tamanho=tam)


if __name__ == '__main__':
  app.run(debug=True)
