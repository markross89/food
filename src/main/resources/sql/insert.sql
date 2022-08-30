INSERT INTO `day_name` (`id`, `name`, `display_order`) VALUES
(1, 'poniedziałek', 1),
(2, 'wtorek', 2),
(3, 'środa', 3),
(4, 'czwartek', 4),
(5, 'piątek', 5),
(6, 'sobota', 6),
(7, 'niedziela', 7);

INSERT INTO `admins` (`id`, `first_name`, `last_name`, `email`, `password`, `superadmin`) VALUES
(1, 'Arek', 'Józwiak', 'arkadiusz.jozwiak@coderslab.pl', '$2a$10$eCrsyeEmdBFktXP1Npubt.KZi9cotr3Bs8cmdVDnj9/OmKvPKzRvi', 1);

INSERT INTO `plan` (`id`, `name`, `description`, `created`, `admin_id`) VALUES
(null, 'Plan Jarski', 'Opis planu 1', '2018-10-17 14:27:05', 1),
(null, 'Plan Mięsny', 'Opis planu 2', '2018-10-17 14:27:05', 1),
(null, 'Plan Śniadaniowy', 'Opis planu 3', '2018-10-17 14:27:05', 1),
(null, 'Plan Redukcja', 'Opis planu 4', '2018-10-17 14:27:05', 1),
(null, 'Plan Dużo białka', 'Opis planu 5', '2018-10-17 14:27:05', 1),
(null, 'Kapuściana dieta', 'Opis planu 6', '2018-10-17 14:27:05', 1)
;

INSERT INTO `recipe` (`id`, `name`, `ingredients`, `description`, `created`, `updated`, `admin_id`, `preparation_time`, `preparation`) VALUES
(null, 'Przepis 1', 'sałata', 'Opis przepisu 1', '2018-10-16 00:00:00', '2018-10-17 14:24:44', 1, 22,'Opis przygotowania 1'),
(null, 'Przepis 2', 'mięso z indyka, pieczarki', 'Opis przepisu 2', '2018-10-16 00:00:00', '2018-10-17 14:24:44', 1, 22,'Opis przygotowania 2'),
(null, 'Przepis 3', 'soczewica, ser feta', 'Opis przepisu 3', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 23,'Opis przygotowania 3'),
(null, 'Przepis 4', 'ciecierzyca, ', 'Opis przepisu 4', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 24,'Opis przygotowania 4'),
(null, 'Przepis 5', 'schab, ziemniaki', 'Opis przepisu 5', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 25,'Opis przygotowania 5'),
(null, 'Przepis 6', 'kapusta, mięso mielone', 'Opis przepisu 6', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 26,'Opis przygotowania 6'),
(null, 'Przepis 7', 'kasza gryczana, cukinia', 'Opis przepisu 7', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 27,'Opis przygotowania 7'),
(null, 'Przepis 8', 'boczek, parmezan, jajka, makaron', 'Opis przepisu 8', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 28,'Opis przygotowania 8'),
(null, 'Przepis 9', 'lody, gruszki', 'Opis przepisu 9', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 29,'Opis przygotowania 9')
;

INSERT INTO `recipe_plan` (`id`, `recipe_id`,  `meal_name`, `display_order`, `day_name_id`, `plan_id`) VALUES
(null, 1,  'Kolacja', 2, 2, 6),
(null, 2,  'Śniadanie', 1, 1, 6),
(null, 1,  'Kolacja', 2, 1, 6),
(null, 3,  'Śniadanie', 1, 2, 6);