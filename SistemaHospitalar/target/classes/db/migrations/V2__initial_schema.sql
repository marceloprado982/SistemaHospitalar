
insert into profissional_saude_entity
 (matricula, nome, departamento, cargo, telefone_profissional)
values
(1000, 'Marcos','Pediatria', 'Pediatria','19999-9999'),
(1024, 'Gloria','Cardiopneumologia', 'Geral','175099-888'),
(1547, 'Frederico','Médico', 'Geral','193599-7777'),
(1258, 'Sandra','Ortopedia e Traumatologia', 'Geral','199899-6666'),
(1245, 'Marcio','Ortopedia e Traumatologia', 'Ortopedista','199479-2222'),
(7895, 'Ana','Cirurgia', 'Geral','19899-1111'),
(1025, 'Richard','Dermatologia', 'Ambulatório Geral e Didático, Alergia','199589-0000');


insert into paciente_entity
  ( nome, telefone, data_nascimento)
values
('Neilton', '197845-6585','25/07/1995'),
('Marcelo', '194745-6585','07/08/1980'),
('Miguel', '197845-6585','30/12/2008'),
('Elaine', '193645-6585','05/05/1960'),
('Simone', '487845-6585','07/07/1998'),
('Rian', '189045-6585','16/11/2010'),
('Claudione', '191807-6585','17/2/2003'),
('Rodrigo', '356284-6585','24/01/1910');


insert into internacao_entity
(paciente_id, nome_paciente,
 data_hora_entrada, data_hora_saida, diagnostico, medico_id)
values
(1,'Neilton','20/04/21 14:30','20/04/21 16:30','Sinusite atacada',3),
(1,'Neilton','20/04/21 16:50','20/04/21 20:30','Sinusite atacada, com febre e virose, desidatração',3),
(2,'Marcelo','21/04/21 14:30','21/04/21 16:14','Dores no peito, começo de infarte ',2),
(3,'Miguel','23/04/21 14:50','23/04/21 15:15','alergia atacada',7),
(4,'Elaine','27/04/21 15:30','27/04/21 16:20','Braço com luxação',5),
(6,'Rian','14/05/21 15:40','14/05/21 17:10','Colica renal',1),
(7,'Claudione','16/05/21 18:40','16/05/21 20:59','Enxaqueca',7),
(3,'Rodrigo','28/05/21 12:30','28/05/21 16:43','Curativo corte pos faca',6),
(3,'Miguel','01/06/21 04:30','01/06/21 04:50','Fratura no pé', 4);
