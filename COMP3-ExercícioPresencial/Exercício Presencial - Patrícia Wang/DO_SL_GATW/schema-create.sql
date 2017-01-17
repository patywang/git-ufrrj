create table cozinha ( id serial primary key, descricao varchar(20));
alter table cozinha add column idPai int;
alter table cozinha add constraint fk_idPai foreign key (idPai) references comodo(id);

create table sala ( id serial primary key, descricao varchar(20));
alter table sala add column idPai int;
alter table sala add constraint fk_idPai foreign key (idPai) references comodo(id);

create table quarto ( id serial primary key, descricao varchar(20));
alter table quarto add column idPai int;
alter table quarto add constraint fk_idPai foreign key (idPai) references comodo(id);


-- 3/10/2016 novas alterações, agr n terá mais tabelas individuais para comodo e sim um campo tipo em comodo:
create table comodo ( id serial primary key, descricao varchar(20));
alter table comodo add column tipo varchar(15);

-- comodo composto - chave estrangeira em comodo de id comodo composto 7/10/2016

alter table comodo add column idComodoComposto int;
alter table comodo add constraint fk_idComodoComposto foreign key(idComodoCOmposto) references comodo(id);


-- mobilia 16/10/2016

create table mobilia ( id serial primary key, descricao varchar(20), custo float, tempoEntrega int);
create table comodo_mobilia (id_mobilia int, id_comodo int);
alter table comodo_mobilia add constraint fk_id_mobilia foreign key (id_mobilia) references mobilia(id) ON DELETE CASCADE ON UPDATE CASCADE;

-- novo comodo composto

create table comodo_composto (id_composto int, id_comodo int);
alter table comodo_composto add constraint fk_id_comodo foreign key (id_comodo) references comodo(id);
alter table comodo_composto add constraint fk_id_composto foreign key (id_composto) references comodo(id);


--LISTAR MOBILIAS DISPONIVEIS

select *
from mobilia m
	join comodo_mobilia cm
	on cm.id_mobilia = m.id
	join comodo c 
	on c.id = cm.id_comodo and c.tipo = 'COZINHA'
	
-- CRIANDO AMBIENTE
	
create table ambiente ( id serial primary key, numParedes int, numPortas int, metragem float);	

-- criando item venda;

create table itemVenda (id serial primary key, id_mobilia int, id_ambiente int, quantidade int);
alter table itemVenda add constraint fk_id_mobilia foreign key (id_mobilia) references mobilia(id);
alter table itemVenda add constraint fk_id_ambiente foreign key (id_ambiente) references ambiente(id);


-- editar comodo composto - sql alterado

alter table comodo_composto
drop constraint fk_id_composto,
add constraint fk_id_composto
foreign key (id_composto) references comodo(id) ON DELETE CASCADE ON UPDATE CASCADE;


-- salvação 
select c2.* from comodo c
join comodo_composto cp on c.id = cp.id_composto
join comodo c2 on cp.id_comodo = c2.id 
where c.id = 60

-- alterando tabela de ambiente 
alter table ambiente add column idContrato int;
alter table ambiente add constraint fk_idContrato foreign key(idContrato) references contrato(id);
