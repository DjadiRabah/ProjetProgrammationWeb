-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : Dim 22 nov. 2020 à 15:39
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projetweb`
--
CREATE DATABASE IF NOT EXISTS `projetweb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projetweb`;

-- --------------------------------------------------------

--
-- Structure de la table `characterprojet`
--

DROP TABLE IF EXISTS `characterprojet`;
CREATE TABLE IF NOT EXISTS `characterprojet` (
  `idCharacter` int(11) NOT NULL AUTO_INCREMENT,
  `nameCharacter` varchar(30) NOT NULL,
  `loreCharacter` varchar(250) DEFAULT NULL,
  `filenameCharacter` varchar(20) NOT NULL COMMENT 'L''image de ton personage',
  `hpCharacter` int(11) NOT NULL,
  `attackCharacter` int(11) NOT NULL,
  `defenseCharacter` int(11) NOT NULL,
  `dodgeCharacter` double NOT NULL,
  `playableCharacter` tinyint(1) NOT NULL,
  PRIMARY KEY (`idCharacter`),
  UNIQUE KEY `naleCharacterUnique` (`nameCharacter`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Déchargement des données de la table `characterprojet`
--

INSERT INTO `characterprojet` (`idCharacter`, `nameCharacter`, `loreCharacter`, `filenameCharacter`, `hpCharacter`, `attackCharacter`, `defenseCharacter`, `dodgeCharacter`, `playableCharacter`) VALUES
(2, 'Aurelien', 'JE suis aurelien 1er du nom', 'nain.jpg', 500, 20, 20, 1, 1),
(5, 'Araigne ', 'C\'est une araignée toute poilus', 'araigner.jpg', 15, 2, 1, 0.05, 0),
(10, 'Squelette', 'Je n\'ai que de la peaux sur les os', 'squelette.jpg', 50, 12, 5, 0.3, 0),
(11, 'Chef des bandits', 'Je fais régner la loi par la force ', 'brigands.jpg', 120, 20, 0, 0.1, 0),
(12, 'bandit', 'Je veux prouver ma valeur a mon chef', 'bandit.jpg', 55, 8, 2, 0.33, 0),
(13, 'djinn', 'Je sors de ma lampe et c\'est pas pour exhausser des veux', 'djin.jpg', 170, 11, 0, 0.4, 0),
(14, 'ent', 'Je s\'appelle Groot', 'ent.jpg', 200, 15, 5, 0, 0),
(15, 'sorciere', 'Aussi repoussante qu\'une pomme pourrit', 'sorciere.jpg', 60, 25, 0, 0.2, 0),
(16, 'troll', 'Aussi fort que bete\r\n', 'troll.jpg', 135, 20, 4, 0.05, 0),
(17, 'dragon', 'Je suis ton dernier soucis', 'dragon.jpg', 300, 25, 5, 0.2, 0);

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
  `nameScreen` varchar(100) CHARACTER SET utf8 NOT NULL,
  `messageScreen` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `idCharacterScreen` int(11) DEFAULT NULL,
  `idChestScreen` int(11) DEFAULT NULL,
  `idScreen1Screen` int(11) DEFAULT NULL,
  `idScreen2Screen` int(11) DEFAULT NULL,
  `idScreen3Screen` int(11) DEFAULT NULL,
  `action1Screen` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `action2Screen` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `action3Screen` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `backGroundScreen` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`idScreen`),
  UNIQUE KEY `idScreen` (`idScreen`,`idChestScreen`),
  KEY `idChest` (`idChestScreen`),
  KEY `idCharacter` (`idCharacterScreen`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `screen`
--

INSERT INTO `screen` (`idScreen`, `nameScreen`, `messageScreen`, `idCharacterScreen`, `idChestScreen`, `idScreen1Screen`, `idScreen2Screen`, `idScreen3Screen`, `action1Screen`, `action2Screen`, `action3Screen`, `backGroundScreen`) VALUES
(1, 'Page_de_depart', 'Le roi de la conter a dit que la personne qui arrivera a récupérer le trésor des mine du roi nain aura le droit d\'épouser la fille\r\nC\'est donc en direction des mine de Nat\'zul que vous vous diriger dans l\'espoir de richesse et d\'épousailles.', NULL, NULL, 2, NULL, NULL, 'Commencer l\'aventure', NULL, NULL, 'trone.jpg\r\n'),
(2, 'permier_choix', 'Vous été a la sortie de la ville et deux chemins s\'offre a vous\r\n\r\n\r\n', NULL, NULL, 4, 18, 3, '1) suivre la caravane de marchant qui se emprunt le même chemin que vous', '2) Passer par les boit maudit qui vous permet de gagner plus de temps mais une veille légende raconte que personne n\'en ai sortie', '3) Rebrousser chemin vous été pas d\'humeur aujourd\'hui', 'sortie_village.jpg'),
(3, 'Fuite', 'Vous avez fait preuve de bon sens ou de lâcheté mais dans tout les cas vous avez échouez a dans votre quête.', NULL, NULL, NULL, NULL, NULL, 'Retourné au menu d\'accueil', NULL, NULL, 'fuite.jpg'),
(4, '', 'Le chemin avec la caravane est long vous passez a travers le champs et differents village.\r\nC\'est en sortant d\'une des ville que vous apercevez au bord de la route un homme au sol on dirait que du sang coule le long des ces vêtements sales', NULL, NULL, 6, 5, NULL, 'Vous vous arrete pour savoir comment il va', 'Vous continuez au galots sans le regarder', NULL, 'caravane.jpg'),
(5, '', 'A quelques mètres de ce mendiant un groupe d\'hommes armés portant l’écusson de l’arme du royaume vous fait signe de vous arrêtez.', NULL, NULL, 6, 7, NULL, 'Vous vous arrêtez', 'Continuez vous êtes pressé', NULL, 'route.jpg\r\n'),
(6, '', 'C’était un piège !!!\r\nL\'homme sors son surin et appelle le reste  de son groupe caché derrière la forêt', NULL, NULL, 9, 11, NULL, 'Attaquer les bandits et protéger les marchands', 'Fuir sans se retourner', NULL, 'route.jpg'),
(7, 'Combat contre le squellette', 'La  nuit commence à tomber vous avez bien avancé dans votre destination.\r\nVous décidez donc avec le groupe de faire halte à la lisière du champ.\r\nMais c\'est au moment ou vous relâcher la pression que surgie du sol des squelettes qui se mettent en marche sur votre groupe et vous encercle.\r\nCombat contre le squelette.', 10, NULL, 8, NULL, NULL, NULL, NULL, NULL, 'squelette_zone.jpg'),
(8, '', 'La nuit fut courte mais c\'est aux premières lueurs du jour que vous reprenez la route et qu\'à une intersection vous apercevez sur un panneau:\r\n-> mine de Nat\'Zul', NULL, NULL, 28, NULL, NULL, 'Tourner à droite', NULL, NULL, 'carrefour'),
(9, 'Combat contre le chef des bandits', 'Vous faites face au groupe de bandits mais dans ce groupe se détache un membre. Il est gros, armé d\'une grande épée, à des cicatrices et plein de tatouages; ça doit être le chef.\r\nSi vous arrivez à la battre les autres partirons surement en courant.\r\nVous foncez sur lui.\r\nCombat contre le chef des bandits.', 11, NULL, 10, NULL, NULL, NULL, NULL, NULL, 'route.jpg'),
(10, '', 'Le combat fut long mais grâce a votre aide les marchants n\'ont eu que des pertes matérielles\r\nVous continuer encore un peu votre route quand vous apercevez un panneau au loin sur un panneau:\r\n-> mine de Nat\'Zul', NULL, NULL, 28, NULL, NULL, 'Tourner à droite', NULL, NULL, 'carrefour.jpg'),
(11, '', 'Vous êtes partie en courant laissant ces pauvres marchants sans défense.\r\nMais au bout de plusieurs minutes de marche vous entendez du bruit de sabot derrière vous.\r\nCe sont les bandits sur les chevaux des marchants.', NULL, NULL, 12, 14, NULL, 'Vous vous retournez et faites volte face aux cavaliers', 'Se jeter dans le bas coter en espérant qu\'il ne vous on pas vue', NULL, 'cheval_loin.jpg'),
(12, '\r\nCombat contre le bandit', 'Vous vous élancez  droit sur le cavalier en poussant des cris.\r\nCet réactions provoquent la stupeur chez le cheval et désarçonne le bandit.\r\nCombat contre le bandit.', 12, NULL, 13, NULL, NULL, NULL, NULL, NULL, 'cheval_loin.jpg'),
(13, '', 'C\'est à la fin de ce combat que vous retrouvez la caravane. Les marchands vont bien. Quelques uns sont blessés et ont des pertes matérielles. Ils ne sont pas contents de vous revoir mais vous remercie quand même pour le cheval.', NULL, NULL, 28, NULL, NULL, 'Continuer son chemin seul', NULL, NULL, 'caravane.jpg'),
(14, '', 'Ouf vous l\'avez échappé belle le cavalier passe juste à coter de vous sans vous remarquer.\r\nVous décidez de continuer votre chemin a l’orée des bois.\r\nEm marchant vous apercevez un hôtel de pierres mystiques.\r\nSur cette hôtel vous apercevez une statuette de marbre orné d\'un petit collier de pierres.', NULL, NULL, 15, 17, NULL, 'Se saisir du collier', 'Continuer son chemin', NULL, 'autel.jpg'),
(15, 'Combat contre un djinn', 'Au moment ou vous toucher le collier une ombre se matérialise devant vous.\r\nUn djinn vient d\'apparaitre.\r\n\"Étranger vous êtes en train de profaner ce sanctuaire et seul la mort pourra vous purifier\".\r\nCombat contre un djinn.', 13, NULL, 16, NULL, NULL, NULL, NULL, NULL, 'autel.jpg'),
(16, '', 'Vous m\'avez battue aventurier, ce collier est a vous. JE vois au fond de vous que cherchez la mine de Nat\'zul continuez tout droit vous ne pouvez pas la louper. ça sera ma récompense pour m\'avoir libéré de cette malédiction.', NULL, NULL, 28, NULL, NULL, 'Aller tout droit', NULL, NULL, 'autel.jpg'),
(17, '', 'En passant à coté de cet autel vous remarquez de nombreux cadavres d\'aventuriers.\r\nC\'est en continuant de marcher que vous apercevez une montagne.\r\nLa grotte doit se situer non loin.', NULL, NULL, 28, NULL, NULL, 'Continuer de chercher la grotte', NULL, NULL, 'montagne.jpg'),
(18, '', 'L\'entrer de la foret noir est plus accueillant que vous l\'imaginez mais au moment ou vous dites sa vous voyez comme les arbre bouger derrière vous\r\net la foret se ressert sur vous et vous sentez quelque chose glisser le long de vos jambes', NULL, NULL, 23, 19, 22, '1) Vous accélèrerez le pas', '2) Vous ne bouger pas\r\n', '3) Vous frappez de toute vos forces', 'foret_noir.jpg'),
(19, '', 'En sentant c\'est étreint autour de votre pied, vous prenez le temps de regarder plus attentivement, vous apercevez un Ent qui se rapproche de de vous\r\nJeune voyageur on dirait que vous été perdus.\r\nJ\'espère que vous ne faite pas partie des ces guimauve rose qui nous attaque et nous brule sans dire bonjour', NULL, NULL, 20, 22, NULL, '1)Se présenter et lui dire ce que vous faite ici\r\n', '2) L\'attaquer de pleine face en visant bien son visage', NULL, 'foret_noir.jpg'),
(20, '', 'Le Ent écoute attentivement votre histoire et vous croit.\r\n\" Si c\'est la grotte de Nat\'zul que vous chercher elle derrière la cabane en bois après la foret. \r\n\r\nMais je vous conseille de dormir maintenant, la nuit va bientôt tomber et vous risquer de vous faire attaquer mais si vous été pressez allez-ci vous pouvez encre sortir de la foret avant la nuit\"', NULL, NULL, 21, 24, NULL, '1) Attendre et passer la nuit avec le Tréant', '2) Continuer avant la tomber de la nuit\r\n', NULL, 'foret_noir.jpg'),
(21, '', 'Vous passez une bonne nuit et vous partez des l\'aurore .\r\nEn suivant les conseille de Ketuki (\"le nom de votre nouvelle amis\")\r\nVous pouvez apercevoir au loin la grotte. ', NULL, NULL, 28, NULL, NULL, '1) Marcher tranquillement vers la grotte', NULL, NULL, 'someil_ent.jpg'),
(22, 'Combat contre un Ent', 'L\'étreint se resserve brusquement .\r\nvous sentez vos pied quitter le sol vous été projeter en l\'air\r\nCombat contre un Ent. ', 14, NULL, 24, NULL, NULL, NULL, NULL, NULL, 'foret_noir.jpg'),
(23, 'Combat contre araigné', 'Vosu courez a toute jambe le souffle vien a manquer.\r\nVous ne savez plus ou vous ete \r\nMais vous remarquer que tout autour de vous de plus en plus de toile d\'araignée se forme \r\nQuand vous vous retourner vous en apercevez une grosse comme un bœuf foncez sur vous\r\n\r\nCombat contre une araignée', 5, NULL, 24, NULL, NULL, NULL, NULL, NULL, 'toile_araigne.jpg'),
(24, '', ' A cause de tout ces péripétie la lune est a son zénith. Il fait déjà nuit noir. Vous pensez être perdus quand vous apercevez au loin une lumière dans une cabane et une douce odeur en émane\r\n\r\n\r\n', NULL, NULL, 25, 29, NULL, '1)Toquer a la porte', '2)Continuer votre chemin', NULL, 'Cabane_sorciere.jpg\r\n'),
(25, '', 'Alors que vous vous apprêter a toquer la porte s\'ouvre délicatement en émettant un grincement.\r\nVous tombez nez a nez avec une veille femme emmitoufler dans un vieux drap. \r\n\"Entre jeune homme tu dois être perdu pour te baladez seul dans une foret à cette heure. Tu dois mourir de faim, prend un peu de soupe sa va te requinquer\"\r\n', NULL, NULL, 26, 29, NULL, '1)Prendre la soupe', '2) La remercie poliment et parti car vous vous été tromper de maison ', NULL, 'Cabane_sorciere.jpg'),
(26, 'Combat contre la sorcière', 'Au gout de la soupe vous sentez quelle est empoissonnez.\r\n\r\nLa veille dame se met a rigolez en sortant son vieux couteau de cuisine\r\n\"Aujourd\'hui c\'est toi qui va être mon repas HAHAHA\"\r\nCombat contre une sorcière', 15, NULL, 27, NULL, NULL, NULL, NULL, NULL, 'interieur_cabane.png\r\n\r\n'),
(27, '', 'Le combat fut long mais après avoir triompher de cette sorcière, vous ne tenez plus debout et  vous vous écroulez de fatigue au coin du feu encore crépitant.\r\nC\'est déjà le matin:\r\n', NULL, NULL, 28, NULL, NULL, '1) Repartir a la recherche la grotte', NULL, NULL, 'interieur_cabane.png'),
(28, '', 'Vous été enfin devant la grotte de Nat\'zul avec ces magnifique relief datant de l\'ancien temps\r\nVous apercevez en bas des relief a ce qui s\'apparente a une porte', NULL, NULL, 30, 3, NULL, '1) Vous entrer', '2) Vous faite demis tous car vous été bien content d\'être encore en vie', NULL, 'grotte_porte.png'),
(29, '', 'En continuant votre chemin vous apercevez une clairière éclaire par les rayon de la lune, vous avez réussir a sortir de la foret en vie.\r\n Vous allumez un feu et vous vous repose enfin\r\nLe soleil se lève:', NULL, NULL, 28, NULL, NULL, '1) Repartir a la recherche de la grotte', NULL, NULL, 'claire_lune.jpg'),
(30, '', 'Vous poussez cet petit porte .\r\nEt une odeur de souffre vous envahie sa sent la mort partout et vous savez pourquoi en voilant la silhouette d\'une énorme troll de dos.\r\n\r\n', NULL, NULL, 31, 33, 34, '1)Le Héler', '2)Le frapper dans le dos', '3) Essaye de le contourner discrètement\r\n', 'entre_grotte.jpg'),
(31, 'Combat contre le troll', 'Le troll vous regarde avec un regarde incrédule  et fonce vers vous.\r\nCombat contre un troll', 16, NULL, 32, NULL, NULL, NULL, NULL, NULL, 'entre_grotte.jpg'),
(32, 'Combat contre le dragon', 'Vous arrivez devant la salle du trône, l\'or et les pierres brillent si forts que vous en été éblouie, ces encore séreux que dans vos rêve , des montagne d\'or et de pierre précieuse a perte de vue. Vous en prenez a pleine main quand un souffle chaud dans votre coup vous ramené a la réaliser\r\nUn gigantesque dragon se tient face a vous.\r\n\"Que fate vous dans mon antre aventurier, vous voulez voler mon or, comme tout les humain vous été corrompus par l\'avarice, pour se pécher vous allez mourir\".\r\nCombat contre un dragon', 17, NULL, 36, NULL, NULL, NULL, NULL, NULL, 'salle_tresor.jpg'),
(33, 'Combat contre le troll', 'Le troll n\'apprécie guère de se faire frapper même subtilement\r\nCombat contre un troll', 16, NULL, 32, NULL, NULL, NULL, NULL, NULL, 'entre_grotte.jpg\r\n'),
(34, '', 'Le troll trop occuper jouer avec des cadavres d\'aventurier mort ne vous vois pas. Vous continuez votre chemin', NULL, NULL, 32, NULL, NULL, '1) Avancer', NULL, NULL, 'entre_grotte.jpg'),
(35, 'defaite au combat', 'Votre aventure se termine ici.\r\n\r\nIl ne vous reste qu\'a recommencer.\r\n\r\nBonne chance', NULL, NULL, NULL, NULL, NULL, 'Retourné au menus d\'accueil', NULL, NULL, 'cimetiere.jpg'),
(36, '', 'BRAVOS , vous avez terrasser le dragon. A vous les trésor et la princesse. \r\nMais une question vous turlupine comment ramenez se trésor, vous avez oublier de prendre un sac.', NULL, NULL, NULL, NULL, NULL, 'Retourne en ville ', NULL, NULL, 'fin.jpg');

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
  ADD CONSTRAINT `SCREENCHARACTER` FOREIGN KEY (`idCharacterScreen`) REFERENCES `characterprojet` (`idCharacter`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `SCREENCHEST` FOREIGN KEY (`idChestScreen`) REFERENCES `chest` (`idChest`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Base de données : `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
