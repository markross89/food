CREATE TABLE contact (
                      id INT AUTO_INCREMENT,
                      name VARCHAR(50),
                      email varchar(50),
                      address varchar(50),
                      phone int,
                      description varchar(200),

                          PRIMARY KEY(id)
);
INSERT INTO contact ( name, email,  address, phone, description) VALUES

                                                         ( 'ZaplanujJedzonko', 'zaplanuj@gmail.com', 'Warszawa ul. Polna 34', 789354427, 'Skontaktuj się znami tel. lub mailowo. można też znaleźć nas na Facebooku')
