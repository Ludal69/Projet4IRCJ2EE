-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 04 Juin 2017 à 19:32
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pge-jee-v1`
--
CREATE DATABASE IF NOT EXISTS `pge-jee-v1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pge-jee-v1`;
--
-- Base de données :  `pge_jpa_v1`
--
CREATE DATABASE IF NOT EXISTS `pge_jpa_v1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pge_jpa_v1`;

-- --------------------------------------------------------

--
-- Structure de la table `events_01`
--

CREATE TABLE `events_01` (
  `events_id` int(11) NOT NULL,
  `events_allDay` bit(1) DEFAULT NULL,
  `events_beginDate` date DEFAULT NULL,
  `events_description` varchar(255) DEFAULT NULL,
  `events_title` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `events_01`
--

INSERT INTO `events_01` (`events_id`, `events_allDay`, `events_beginDate`, `events_description`, `events_title`) VALUES
(2, b'0', '2017-01-12', 'Description du deuxime vnement', 'Deuxime vnement');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `events_01`
--
ALTER TABLE `events_01`
  ADD PRIMARY KEY (`events_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `events_01`
--
ALTER TABLE `events_01`
  MODIFY `events_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;--
-- Base de données :  `pge_jpa_v2`
--
CREATE DATABASE IF NOT EXISTS `pge_jpa_v2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pge_jpa_v2`;

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

CREATE TABLE `adresses` (
  `adresses_id` int(11) NOT NULL,
  `adresses_city` varchar(255) DEFAULT NULL,
  `adresses_comments` varchar(255) DEFAULT NULL,
  `adresses_name` varchar(255) NOT NULL,
  `adresses_street` varchar(255) DEFAULT NULL,
  `adresses_zipcode` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `adresses`
--

INSERT INTO `adresses` (`adresses_id`, `adresses_city`, `adresses_comments`, `adresses_name`, `adresses_street`, `adresses_zipcode`) VALUES
(1, 'Paris', NULL, 'Nom de l\'adresse', '24 rue des cerisiers', '75001');

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

CREATE TABLE `events` (
  `events_id` int(11) NOT NULL,
  `events_allDay` bit(1) DEFAULT NULL,
  `events_beginDate` date DEFAULT NULL,
  `events_description` varchar(255) DEFAULT NULL,
  `events_title` varchar(255) NOT NULL,
  `events_addressID` int(11) DEFAULT NULL,
  `events_userID` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `events`
--

INSERT INTO `events` (`events_id`, `events_allDay`, `events_beginDate`, `events_description`, `events_title`, `events_addressID`, `events_userID`) VALUES
(1, b'0', '2017-01-12', '', 'Event sans adresse', NULL, 1),
(2, b'1', '2017-01-12', 'description', 'Titre de l\'vnement', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `guests`
--

CREATE TABLE `guests` (
  `guests_id` int(11) NOT NULL,
  `guests_email` varchar(255) DEFAULT NULL,
  `guests_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `guests`
--

INSERT INTO `guests` (`guests_id`, `guests_email`, `guests_name`) VALUES
(1, 'invite@mistra.fr', 'Invit 1'),
(2, 'guest@mistra.fr', 'Invit 2');

-- --------------------------------------------------------

--
-- Structure de la table `guests_events`
--

CREATE TABLE `guests_events` (
  `guestId` int(11) NOT NULL,
  `eventId` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `guests_events`
--

INSERT INTO `guests_events` (`guestId`, `eventId`) VALUES
(1, 2),
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `items`
--

CREATE TABLE `items` (
  `items_id` int(11) NOT NULL,
  `items_currentQuantity` int(11) DEFAULT NULL,
  `items_name` varchar(255) DEFAULT NULL,
  `items_neededQuantity` int(11) DEFAULT NULL,
  `items_eventId` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `items`
--

INSERT INTO `items` (`items_id`, `items_currentQuantity`, `items_name`, `items_neededQuantity`, `items_eventId`) VALUES
(1, 2, 'jus d\'orange', 5, 1),
(2, 0, 'chips', 3, 1),
(3, 1, 'pistaches', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `users_id` int(11) NOT NULL,
  `users_email` varchar(255) DEFAULT NULL,
  `users_login` varchar(255) DEFAULT NULL,
  `users_pass` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`users_id`, `users_email`, `users_login`, `users_pass`) VALUES
(1, 'mistra@mistra.fr', 'mistra', 'formation'),
(2, 'john.doe@mistra.fr', 'John Doe', 'password');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adresses`
--
ALTER TABLE `adresses`
  ADD PRIMARY KEY (`adresses_id`);

--
-- Index pour la table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`events_id`),
  ADD KEY `FKB307E1196763E8CF` (`events_userID`),
  ADD KEY `FKB307E119874EF865` (`events_addressID`);

--
-- Index pour la table `guests`
--
ALTER TABLE `guests`
  ADD PRIMARY KEY (`guests_id`);

--
-- Index pour la table `guests_events`
--
ALTER TABLE `guests_events`
  ADD KEY `FK23C1DC3DBA5284D3` (`guestId`),
  ADD KEY `FK23C1DC3D521CE5D7` (`eventId`);

--
-- Index pour la table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`items_id`),
  ADD KEY `FK5FDE7C08B26B458` (`items_eventId`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`users_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `adresses`
--
ALTER TABLE `adresses`
  MODIFY `adresses_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `events`
--
ALTER TABLE `events`
  MODIFY `events_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `guests`
--
ALTER TABLE `guests`
  MODIFY `guests_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `items`
--
ALTER TABLE `items`
  MODIFY `items_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `users_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;--
-- Base de données :  `pgejeev1`
--
CREATE DATABASE IF NOT EXISTS `pgejeev1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pgejeev1`;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `identifiant` varchar(255) DEFAULT NULL,
  `motdepasse` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `email`, `identifiant`, `motdepasse`) VALUES
(1, 'mistra@formation.fr', 'mistra', 'formation'),
(2, 'login@formation.fr', 'login', 'pass');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;--
-- Base de données :  `projet4irc_jee`
--
CREATE DATABASE IF NOT EXISTS `projet4irc_jee` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projet4irc_jee`;

-- --------------------------------------------------------

--
-- Structure de la table `ingrediant`
--

CREATE TABLE `ingrediant` (
  `ingrediant_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `ingrediant`
--

INSERT INTO `ingrediant` (`ingrediant_id`, `name`, `description`) VALUES
(1, 'Riz', NULL),
(2, 'Petits poids', NULL),
(3, 'Jambon', NULL),
(4, 'Oeufs en omelette', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `recipe`
--

CREATE TABLE `recipe` (
  `recipe_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `duration` int(4) NOT NULL,
  `level` int(1) NOT NULL,
  `number_people` int(2) NOT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `recipe`
--

INSERT INTO `recipe` (`recipe_id`, `name`, `duration`, `level`, `number_people`, `type`) VALUES
(4, 'Ramequins fondants au chocolat', 22, 1, 4, 'Dessert'),
(5, 'tarte au citron meringuée', 55, 2, 6, 'Dessert'),
(6, 'Tiramisu', 15, 2, 8, 'Dessert'),
(7, 'Blanquette de veau', 135, 3, 4, 'Meal'),
(8, 'Fondue de poissons', 35, 5, 2, 'Fish');

-- --------------------------------------------------------

--
-- Structure de la table `recipelinkingrediant`
--

CREATE TABLE `recipelinkingrediant` (
  `ingrediant_id` int(11) NOT NULL,
  `recipe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `recipelinkingrediant`
--

INSERT INTO `recipelinkingrediant` (`ingrediant_id`, `recipe_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `login` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pwd` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `firstname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isconnected` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`user_id`, `login`, `pwd`, `firstname`, `lastname`, `age`, `email`, `isconnected`) VALUES
(1, 'az', 'az', '', '', 0, 'az', NULL),
(2, 'ze', 'ze', 'ze', 'ze', 82, 'aze', NULL),
(3, 'sdcx', 'zqdsx', 'az', 'zedsfxc', 0, 'zd<esfvxc', NULL),
(4, '', '', 'zae', '', 0, '', NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `ingrediant`
--
ALTER TABLE `ingrediant`
  ADD PRIMARY KEY (`ingrediant_id`);

--
-- Index pour la table `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`recipe_id`);

--
-- Index pour la table `recipelinkingrediant`
--
ALTER TABLE `recipelinkingrediant`
  ADD PRIMARY KEY (`ingrediant_id`,`recipe_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `ingrediant`
--
ALTER TABLE `ingrediant`
  MODIFY `ingrediant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `recipe`
--
ALTER TABLE `recipe`
  MODIFY `recipe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;--
-- Base de données :  `projetjee`
--
CREATE DATABASE IF NOT EXISTS `projetjee` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projetjee`;

-- --------------------------------------------------------

--
-- Structure de la table `ingrediant`
--

CREATE TABLE `ingrediant` (
  `ingrediant_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `ingrediant`
--

INSERT INTO `ingrediant` (`ingrediant_id`, `name`, `description`) VALUES
(1, 'Riz', NULL),
(2, 'Petits poids', NULL),
(3, 'Jambon', NULL),
(4, 'Oeufs en omelette', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `recipe`
--

CREATE TABLE `recipe` (
  `recipe_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `duration` int(4) NOT NULL,
  `level` int(1) NOT NULL,
  `number_people` int(2) NOT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `recipe`
--

INSERT INTO `recipe` (`recipe_id`, `name`, `duration`, `level`, `number_people`, `type`) VALUES
(4, 'Ramequins fondants au chocolat', 22, 1, 4, 'Dessert'),
(5, 'tarte au citron meringuée', 55, 2, 6, 'Dessert'),
(6, 'Tiramisu', 15, 2, 8, 'Dessert'),
(7, 'Blanquette de veau', 135, 3, 4, 'Meal'),
(8, 'Fondue de poissons', 35, 5, 2, 'Fish'),
(9, 'Filet mignon en croûte', 60, 2, 6, 'Meal'),
(10, 'Lasagnes à la bolognaise', 60, 2, 6, 'Meal'),
(11, 'Amour de saumon en papillote', 60, 2, 6, 'Meal'),
(12, 'Poulet à la moutarde et aux champignons', 60, 2, 6, 'Meal'),
(13, 'Sauté de veau au chorizo', 60, 2, 6, 'Meal');

-- --------------------------------------------------------

--
-- Structure de la table `recipelinkingrediant`
--

CREATE TABLE `recipelinkingrediant` (
  `ingrediant_id` int(11) NOT NULL,
  `recipe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `recipelinkingrediant`
--

INSERT INTO `recipelinkingrediant` (`ingrediant_id`, `recipe_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `login` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pwd` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `firstname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isconnected` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`user_id`, `login`, `pwd`, `firstname`, `lastname`, `age`, `email`, `isconnected`) VALUES
(1, 'az', 'az', '', '', 0, 'az', NULL),
(2, 'ze', 'ze', 'ze', 'ze', 82, 'aze', NULL),
(3, 'sdcx', 'zqdsx', 'az', 'zedsfxc', 0, 'zd<esfvxc', NULL),
(4, '', '', 'zae', '', 0, '', NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `ingrediant`
--
ALTER TABLE `ingrediant`
  ADD PRIMARY KEY (`ingrediant_id`);

--
-- Index pour la table `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`recipe_id`);

--
-- Index pour la table `recipelinkingrediant`
--
ALTER TABLE `recipelinkingrediant`
  ADD PRIMARY KEY (`ingrediant_id`,`recipe_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `ingrediant`
--
ALTER TABLE `ingrediant`
  MODIFY `ingrediant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `recipe`
--
ALTER TABLE `recipe`
  MODIFY `recipe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
