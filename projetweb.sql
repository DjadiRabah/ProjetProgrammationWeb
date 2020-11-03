-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 03 nov. 2020 à 07:50
-- Version du serveur :  10.3.12-MariaDB
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `characterprojet`
--

DROP TABLE IF EXISTS `characterprojet`;
CREATE TABLE IF NOT EXISTS `characterprojet` (
  `idCharacter` int(11) NOT NULL AUTO_INCREMENT,
  `nameCharacter` varchar(30) NOT NULL,
  `hpCharacter` int(11) DEFAULT NULL,
  `attackCharacter` int(11) DEFAULT NULL,
  `defenseCharacter` int(11) DEFAULT NULL,
  `dodgeCharacter` double DEFAULT NULL,
  PRIMARY KEY (`idCharacter`),
  UNIQUE KEY `naleCharacterUnique` (`nameCharacter`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Déchargement des données de la table `characterprojet`
--

INSERT INTO `characterprojet` (`idCharacter`, `nameCharacter`, `hpCharacter`, `attackCharacter`, `defenseCharacter`, `dodgeCharacter`) VALUES
(1, 'test', 100, 200, 300, 400);

-- --------------------------------------------------------

--
-- Structure de la table `chest`
--

DROP TABLE IF EXISTS `chest`;
CREATE TABLE IF NOT EXISTS `chest` (
  `idChest` int(11) NOT NULL AUTO_INCREMENT,
  `idItem` int(11) NOT NULL,
  PRIMARY KEY (`idChest`),
  KEY `idItem` (`idItem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `nameItem` varchar(20) CHARACTER SET utf8 NOT NULL,
  `hpItem` int(11) DEFAULT NULL,
  `attackItem` int(11) DEFAULT NULL,
  `defenseItem` int(11) DEFAULT NULL,
  `dodgeItem` double DEFAULT NULL,
  PRIMARY KEY (`idItem`),
  UNIQUE KEY `itemName` (`nameItem`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `item`
--

INSERT INTO `item` (`idItem`, `nameItem`, `hpItem`, `attackItem`, `defenseItem`, `dodgeItem`) VALUES
(1, 'Rabah don', 0, 300, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `screen`
--

DROP TABLE IF EXISTS `screen`;
CREATE TABLE IF NOT EXISTS `screen` (
  `idScreen` int(11) NOT NULL AUTO_INCREMENT,
  `nameScreen` varchar(30) CHARACTER SET utf8 NOT NULL,
  `messageStartScreen` varchar(200) CHARACTER SET utf8 NOT NULL,
  `idCharacter` int(11) DEFAULT NULL,
  `idChest` int(11) DEFAULT NULL,
  `nextScreens` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`idScreen`),
  UNIQUE KEY `nameScreen` (`nameScreen`),
  UNIQUE KEY `idScreen` (`idScreen`,`idChest`),
  KEY `idChest` (`idChest`),
  KEY `idCharacter` (`idCharacter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chest`
--
ALTER TABLE `chest`
  ADD CONSTRAINT `CHESTITEM` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `screen`
--
ALTER TABLE `screen`
  ADD CONSTRAINT `SCREENCHEST` FOREIGN KEY (`idChest`) REFERENCES `chest` (`idChest`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
