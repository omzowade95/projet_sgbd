-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 07 mai 2021 à 16:52
-- Version du serveur :  10.1.33-MariaDB
-- Version de PHP :  7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `covid`
--

-- --------------------------------------------------------

--
-- Structure de la table `arrondissement`
--

CREATE TABLE `arrondissement` (
  `idArr` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nomArr` varchar(255) DEFAULT NULL,
  `arrondissements_idCommune` int(11) DEFAULT NULL,
  `idC` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `arrondissement`
--

INSERT INTO `arrondissement` (`idArr`, `code`, `nomArr`, `arrondissements_idCommune`, `idC`) VALUES
(1, 'A-1-A-1', 'Almadies', 1, 0),
(2, 'A-1-A-2', 'Dakar Plateau ', 1, 0),
(3, 'A-1-A-3', 'Grand Dakar ', 1, 0),
(4, 'A-1-A-4', 'Parcelles Assainies', 1, 0),
(5, 'A-2-A-1', 'Guediawaye', 2, 0),
(6, 'A-3-A-1', 'Pikine Dagoudane', 3, 0),
(7, 'A-3-A-2', 'Niayes', 3, 0),
(8, 'A-3-A-3', 'Thiaroye', 3, 0),
(9, 'A-4-C-A', 'Rufisque', 6, 0),
(10, 'A-4-C-B', 'Sangalkam', 6, 0),
(11, 'B-1-A-1', 'Baba Garage', 8, 0),
(12, 'B-1-A-2', 'Lambaye', 8, 0),
(13, 'B-1-A-3', 'Ngoye', 8, 0),
(14, 'B-2-B-1', 'Ndindy', 9, 0),
(15, 'B-2-B-2', 'Ndoulo', 9, 0),
(16, 'B-3-C-1', 'Kael', 10, 0),
(17, 'B-3-C-2', 'Ndame', 10, 0),
(18, 'B-3-C-3', 'Taïf', 10, 0),
(19, 'C-1-B-1', 'Diakhao', 12, 0),
(20, 'C-1-B-2', 'Fimela', 12, 0),
(21, 'C-1-B-3', 'Niakhar', 12, 0),
(22, 'C-1-B-4', 'Tattaguine', 12, 0),
(23, 'C-2-C-1', 'Djilor', 17, 0),
(24, 'C-1-D-1', 'Niodior', 14, 0),
(25, 'C-2-C-2', 'Toubacouta', 17, 0),
(26, 'E-1-B-1', 'Colobane', 19, 0),
(27, 'E-1-B-2', 'Mbadakhoune', 19, 0),
(28, 'C-3-A-1', 'Ouadiour', 19, 0),
(29, 'D-1-A-1', 'Birkilane', 20, 0),
(30, 'D-1-A-2', 'Maka yop', 20, 0),
(31, 'D-1-A-3', 'Malem Hodar', 20, 0),
(32, 'D-3-A-1', 'Kakatel', 22, 0),
(33, 'D-3-A-2', 'Gniby', 22, 0),
(34, 'E-3-B-1', 'Medina Sabakh', 34, 0),
(35, 'E-3-B-2', 'Paoscoto', 34, 0),
(36, 'E-3-B-3', 'Wack ngouna', 34, 0),
(37, 'M-2-D-1', 'Keur Moussa', 115, 0),
(38, 'M-2-D-2', 'Notto', 115, 0),
(39, 'M-2-D-3', 'Thiénaba', 115, 0),
(40, 'M-3-B-1', 'Médina Dakhar', 117, 0),
(41, 'M-3-B-2', 'Méouane', 117, 0),
(42, 'M-3-A-1', 'Niakhène', 116, 0),
(43, 'M-3-A-2', 'Pambal', 116, 0),
(44, 'N-3-C-1', 'Diouloulou', 121, 0),
(45, 'N-3-C-2', 'Sindian', 121, 0),
(46, 'N-3-C-3', 'Tendouck', 121, 0),
(47, 'N-3-C-4', 'Tenghory', 121, 0),
(48, 'N-2-A-1', 'Cabrousse', 122, 0),
(49, 'N-2-A-2', 'Loudia Ouoloff', 122, 0),
(50, 'N-1-A-1', 'Niaguis', 123, 0),
(51, 'N-1-A-2', 'Niassia', 123, 0);

-- --------------------------------------------------------

--
-- Structure de la table `commune`
--

CREATE TABLE `commune` (
  `idCommune` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nomCommune` varchar(255) DEFAULT NULL,
  `commune_idDept` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commune`
--

INSERT INTO `commune` (`idCommune`, `code`, `nomCommune`, `commune_idDept`) VALUES
(1, 'A-1-A', 'Dakar', 1),
(2, 'A-2-A', 'Guediawaye', 3),
(3, 'A-3-A', 'Pikine', 2),
(4, 'A-4-A', 'Bargny', 4),
(5, 'A-4-B', 'Diamniadio', 4),
(6, 'A-4-C', 'Rufisque', 4),
(7, 'A-4-D', 'Sebikotane', 4),
(8, 'B-1-A', 'Bambey', 5),
(9, 'B-2-B', 'Diourbel', 6),
(10, 'B-3-C', 'Mbacke', 7),
(11, 'C-1-A', 'Diakhao', 8),
(12, 'C-1-B', 'Diofior', 8),
(13, 'C-1-C', 'Fatick', 8),
(14, 'C-1-D', 'Foundiougne', 9),
(15, 'C-2-A', 'Karang poste', 9),
(16, 'C-2-B', 'Passi', 9),
(17, 'C-2-C', 'Sokone', 9),
(18, 'C-2-D', 'Soum', 9),
(19, 'C-3-A', 'Gossas', 10),
(20, 'D-1-A', 'Birkilane', 11),
(21, 'D-2-A', 'Kaffrine', 12),
(22, 'D-3-A', 'Nganda', 13),
(23, 'D-4-A', 'Koungheul', 14),
(24, 'D-5-A', 'Malem Hodar', 15),
(25, 'E-1-A', 'Fass', 16),
(26, 'E-1-B', 'Guinguineo', 16),
(27, 'E-1-C', 'Mboss', 16),
(28, 'E-2-A', 'Gandiaye', 17),
(29, 'E-2-B', 'Kahone', 17),
(30, 'E-2-C', 'Kaplack', 17),
(31, 'E-2-D', 'Ndoffane', 17),
(32, 'E-2-E', 'Sibassor', 17),
(33, 'E-3-A', 'Keur Mabiabel ', 17),
(34, 'E-3-B', 'Nioro', 18),
(35, 'F-1-A', 'Kedougou', 19),
(36, 'F-2-A', 'Salemata', 20),
(37, 'F-3-A', 'Saraya', 21),
(38, 'G-1-A', 'Dabo', 22),
(39, 'G-1-B', 'Kolda', 22),
(40, 'G-1-C', 'Salikegne', 22),
(41, 'G-1-D', 'Sare Yoba Diega', 22),
(42, 'G-2-A', 'Medina Yoro Foulah', 23),
(43, 'G-2-B', 'Pata', 24),
(44, 'G-3-A', 'Diaobe Kabendou', 24),
(45, 'G-3-B', 'Kounkane', 24),
(46, 'G-3-C', 'Velingara', 24),
(47, 'H-1-A', 'Gueoul', 25),
(48, 'H-1-B', 'Kebemer', 25),
(49, 'H-2-A', 'Dahra', 26),
(50, 'H-2-B', 'Linguere', 26),
(51, 'H-2-C', 'Mbeuleukhe', 26),
(52, 'H-3-A', 'Louga ', 27),
(53, 'H-3-B', 'Ndiagne', 27),
(54, 'I-1-A', 'Dembancane', 28),
(55, 'I-1-B', 'Hamadi Hounae ', 28),
(56, 'I-1-C', 'Kanel', 28),
(57, 'I-1-D', 'Odobere', 28),
(58, 'I-1-E', 'Ouande', 28),
(59, 'I-1-F', 'Semme', 28),
(60, 'I-1-G', 'Sinthiou', 28),
(61, 'I-2-A', 'Matam', 29),
(62, 'I-2-B', 'Nguidjilone', 29),
(63, 'I-2-C', 'Ourossogui', 29),
(64, 'I-2-D', 'Thilogne', 29),
(65, 'I-3-A', 'Ranerou', 30),
(66, 'J-1-A', 'Dagana', 31),
(67, 'J-1-B', 'Gae', 31),
(68, 'J-1-C', 'Ndombo Sandjiry', 31),
(69, 'J-1-D', 'Richard Toll', 31),
(70, 'J-1-E', 'Ross Bethio', 31),
(71, 'J-1-F', 'Rosso Senegal', 31),
(72, 'J-2-A', 'Aere Lao', 32),
(73, 'J-2-B', 'Bode Lao', 32),
(74, 'J-2-C', 'Demette', 32),
(75, 'J-2-D', 'Galoya Toucouleur', 32),
(76, 'J-2-E', 'Gollere', 32),
(77, 'J-2-F', 'Guede Chantier ', 32),
(78, 'J-2-G', 'Mbouma', 32),
(79, 'J-2-H', 'Ndioum', 32),
(80, 'J-2-I', 'Niandane', 32),
(81, 'J-2-J', 'Pete', 32),
(82, 'J-2-K', 'Podor', 32),
(83, 'J-2-L', 'Walalde', 32),
(84, 'J-3-A', 'Mpal', 33),
(85, 'J-3-B', 'Saint-Louis', 33),
(86, 'K-1-A', 'Bounkiling', 34),
(87, 'K-1-B', 'Madina Wandifa', 34),
(88, 'K-1-C', 'Ndiamacouta', 34),
(89, 'K-2-A', 'Diattacounda', 35),
(90, 'K-2-B', 'Goudomp', 35),
(91, 'K-2-C', 'Samine', 35),
(92, 'K-2-D', 'Tanaff', 35),
(93, 'K-3-A', 'Dianah malary', 36),
(94, 'K-3-B', 'Marssassoum', 36),
(95, 'K-3-C', 'Sedhiou', 36),
(96, 'L-1-A', 'Bakel', 37),
(97, 'L-1-B', 'Diawara', 37),
(98, 'L-1-C', 'Kidira', 37),
(99, 'L-2-A', 'Goudiry', 38),
(100, 'L-2-B', 'Kothiary', 38),
(101, 'L-3-A', 'Koumpentoum', 39),
(102, 'L-3-B', 'Maleme Niani', 39),
(103, 'L-4-A', 'Tambacounda', 40),
(104, 'M-1-A', 'Joal Fadiouth', 41),
(105, 'M-1-B', 'Mbour', 41),
(106, 'M-1-C', 'Ngaparou', 41),
(107, 'M-1-D', 'Nguekhokh', 41),
(108, 'M-1-E', 'Popenguine-Ndayane', 41),
(109, 'M-1-F', 'Saly Portudal', 41),
(110, 'M-1-G', 'Somone', 41),
(111, 'M-1-H', 'Thiadiaye', 41),
(112, 'M-2-A', 'Thies', 42),
(113, 'M-2-B', 'Kayar', 42),
(114, 'M-2-C', 'Khombole', 42),
(115, 'M-2-D', 'Pout', 42),
(116, 'M-3-A', 'Mboro', 43),
(117, 'M-3-B', 'Mekhe', 43),
(118, 'M-3-C', 'Tivaoune', 43),
(119, 'N-3-A', 'Bignona', 46),
(120, 'N-3-B', 'Diouloulou', 46),
(121, 'N-3-C', 'Thionck Essyl', 46),
(122, 'N-2-A', 'Oussouye', 45),
(123, 'N-1-A', 'Ziguinchor', 44);

-- --------------------------------------------------------

--
-- Structure de la table `communique`
--

CREATE TABLE `communique` (
  `idCommunique` int(11) NOT NULL,
  `dateCommunique` varchar(255) NOT NULL,
  `nbCasCommun` int(11) NOT NULL,
  `nbDeces` int(11) NOT NULL,
  `nbGueri` int(11) NOT NULL,
  `nbNouveauCas` int(11) NOT NULL,
  `nbTest` int(11) NOT NULL,
  `nomCommunique` varchar(255) NOT NULL,
  `nomFichier` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `communique`
--

INSERT INTO `communique` (`idCommunique`, `dateCommunique`, `nbCasCommun`, `nbDeces`, `nbGueri`, `nbNouveauCas`, `nbTest`, `nomCommunique`, `nomFichier`) VALUES
(6, 'ddd', 3, 5, 5, 2, 1, 'nn', 't'),
(8, 'ddd', 3, 5, 5, 2, 1, 'nn', 't'),
(11, 'ddd', 3, 5, 5, 2, 1, 'nn', 't');

-- --------------------------------------------------------

--
-- Structure de la table `communiquelocalite`
--

CREATE TABLE `communiquelocalite` (
  `id` int(11) NOT NULL,
  `codeLoc` varchar(255) DEFAULT NULL,
  `nombreCas` int(11) NOT NULL,
  `communique_idCommunique` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `communiquelocalite`
--

INSERT INTO `communiquelocalite` (`id`, `codeLoc`, `nombreCas`, `communique_idCommunique`) VALUES
(7, 'A', 4, 6),
(9, 'A', 4, 8),
(10, 'A', 4, 8),
(12, 'A', 4, 11),
(13, 'A', 4, 11);

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `idDept` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nomDept` varchar(255) DEFAULT NULL,
  `departement_idRegion` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `departement`
--

INSERT INTO `departement` (`idDept`, `code`, `nomDept`, `departement_idRegion`) VALUES
(1, 'A-1', 'Dakar', 1),
(2, 'A-2', 'Pikine', 1),
(3, 'A-3', 'GUEDIAWAYE', 1),
(4, 'A-4', 'RUFISQUE', 1),
(5, 'B-1', 'BAMBEY', 2),
(6, 'B-2', 'DIOURBEL', 2),
(7, 'B-3', 'MBACKE', 2),
(8, 'C-1', 'FATICK ', 3),
(9, 'C-2', 'FOUNDIOUGNE', 3),
(10, 'C-3', 'GOSSAS', 3),
(11, 'D-1', 'BIRKILANE', 4),
(12, 'D-2', 'KAFFRINE', 4),
(13, 'D-3', 'NGANDA', 4),
(14, 'D-4', 'KOUNGHEUL', 4),
(15, 'D-5', 'MALEM HODDAR', 4),
(16, 'E-1', 'GUINGUINEO', 5),
(17, 'E-2', 'KAOLACK', 5),
(18, 'E-3', 'NIORO', 5),
(19, 'F-1', 'KEDOUGOU', 6),
(20, 'F-2', 'SALEMATA', 6),
(21, 'F-3', 'SARAYA', 6),
(22, 'G-1', 'KOLDA', 7),
(23, 'G-2', 'MEDINA YORO FOULAH', 7),
(24, 'G-3', 'VELINGARA', 7),
(25, 'H-1', 'KEBEMER', 8),
(26, 'H-2', 'LINGUERE', 8),
(27, 'H-3', 'LOUGA', 8),
(28, 'I-1', 'KANEL', 9),
(29, 'I-2', 'MATAM', 9),
(30, 'I-3', 'RANEROU FERLO', 9),
(31, 'J-1', 'DAGANA ', 10),
(32, 'J-2', 'PODOR ', 10),
(33, 'J-3', 'SAINT LOUIS ', 10),
(34, 'K-1', 'BOUNKILING ', 11),
(35, 'K-2', 'GOUDOMP ', 11),
(36, 'K-3', 'SEDHIOU', 11),
(37, 'L-1', 'BAKEL', 12),
(38, 'L-2', 'GOUDIRY', 12),
(39, 'L-3', 'KOUPENTOUM', 12),
(40, 'L-4', 'TAMBA', 12),
(41, 'M-1', 'MBOUR', 13),
(42, 'M-2', 'THIES', 13),
(43, 'M-3', 'TIVAOUANE', 13),
(44, 'N-1', 'ZIGUINCHOR', 14),
(45, 'N-2', 'OUSSOUYE', 14),
(46, 'N-3', 'BIGNONA', 14);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(14);

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE `region` (
  `idRegion` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nomRegion` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `region`
--

INSERT INTO `region` (`idRegion`, `code`, `nomRegion`) VALUES
(1, 'A', 'DAKAR'),
(2, 'B', 'DIOURBEL'),
(3, 'C', 'FATICK'),
(4, 'D', 'KAFFRINE'),
(5, 'E', 'KAOLACK'),
(6, 'F', 'KEDOUGOU'),
(7, 'G', 'KOLDA'),
(8, 'H', 'LOUGA'),
(9, 'I', 'MATAM'),
(10, 'J', 'SAINT LOUIS'),
(11, 'K', 'SEDHIOU'),
(12, 'L', 'TAMBACOUNDA'),
(13, 'M', 'THIES'),
(14, 'N', 'ZIGUINCHOR');

-- --------------------------------------------------------

--
-- Structure de la table `vaccination`
--

CREATE TABLE `vaccination` (
  `id` int(11) NOT NULL,
  `nctotal` int(11) NOT NULL,
  `nombreCasJour` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `arrondissement`
--
ALTER TABLE `arrondissement`
  ADD PRIMARY KEY (`idArr`),
  ADD UNIQUE KEY `UK_eyeuhae1pcknhdo8rbsxchoq8` (`code`),
  ADD KEY `FKknya3u99bspmoexnxnihm9ba` (`arrondissements_idCommune`);

--
-- Index pour la table `commune`
--
ALTER TABLE `commune`
  ADD PRIMARY KEY (`idCommune`),
  ADD UNIQUE KEY `UK_map2r16ckawlaluff833nm549` (`code`),
  ADD KEY `FKs8o2oridxs5tawhv0thdtrkvu` (`commune_idDept`);

--
-- Index pour la table `communique`
--
ALTER TABLE `communique`
  ADD PRIMARY KEY (`idCommunique`);

--
-- Index pour la table `communiquelocalite`
--
ALTER TABLE `communiquelocalite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjq2eokcermol7805ycq3fo0xh` (`communique_idCommunique`);

--
-- Index pour la table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`idDept`),
  ADD UNIQUE KEY `UK_l8rojgxspoh0heyoqulnmt3cd` (`code`),
  ADD KEY `FK2scvegw56oh9s42iugn4bcna` (`departement_idRegion`);

--
-- Index pour la table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`idRegion`),
  ADD UNIQUE KEY `UK_2ylxp2r1fwrjgbh1mihfu656u` (`code`);

--
-- Index pour la table `vaccination`
--
ALTER TABLE `vaccination`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
