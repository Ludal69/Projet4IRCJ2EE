-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 02 Juin 2017 à 13:45
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet4irc_jee`
--

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
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
