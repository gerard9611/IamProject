-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 15, 2016 at 10:27 PM
-- Server version: 5.5.25
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `iam`
--

-- --------------------------------------------------------

--
-- Table structure for table `IDENTITIES`
--

CREATE TABLE `IDENTITIES` (
  `IDENTITIES_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDENTITIES_BIRTHDATE` date DEFAULT NULL,
  `IDENTITIES_EMAIL` varchar(255) DEFAULT NULL,
  `IDENTITIES_FIRSTNAME` varchar(255) DEFAULT NULL,
  `IDENTITIES_LASTNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDENTITIES_ID`),
  UNIQUE KEY `IDENTITIES_EMAIL` (`IDENTITIES_EMAIL`),
  UNIQUE KEY `UK_ro9052ihlliuohcmvnkcbymo8` (`IDENTITIES_EMAIL`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `IDENTITIES`
--

INSERT INTO `IDENTITIES` (`IDENTITIES_ID`, `IDENTITIES_BIRTHDATE`, `IDENTITIES_EMAIL`, `IDENTITIES_FIRSTNAME`, `IDENTITIES_LASTNAME`) VALUES
(1, '2016-03-22', 'test@test.com', 'sdsd', 'testing1'),
(2, '2016-03-22', 'thomas.broussard@gmail.com', 'Thomas', 'Broussard'),
(3, '1989-01-10', 'hello1@hello.com', 'Gerard', 'Barakat'),
(4, '1900-01-01', 'test@123.com', 'testing', 'test'),
(5, '1990-01-10', 'hello123@123.com', 'w1w1w1', 'w2w2w2'),
(7, '1989-10-01', 'gerard@barakat.com', 'Gerard', 'Barakat'),
(10, '2016-05-12', 'test@hello.com', 'ghjghj', 'ghjghj'),
(16, '2016-05-01', 'test@test11.com', 'gggg', 'ggg'),
(20, '2016-05-01', 'gerard@gerard.com', 'gerard', 'gerard');

-- --------------------------------------------------------

--
-- Table structure for table `USERS`
--

CREATE TABLE `USERS` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_PASSWORD` varchar(255) DEFAULT NULL,
  `USER_USERNAME` varchar(255) DEFAULT NULL,
  `USERIDENTITY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_USERNAME` (`USER_USERNAME`),
  UNIQUE KEY `UK_b45gltaekakvn3h2g1fff6qgp` (`USER_USERNAME`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `USERS`
--

INSERT INTO `USERS` (`USER_ID`, `USER_PASSWORD`, `USER_USERNAME`, `USERIDENTITY_ID`) VALUES
(1, '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'gerard', NULL),
(3, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', 'testing1', 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
