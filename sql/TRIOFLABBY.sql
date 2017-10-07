-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2017 at 11:38 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trioflabby`
--

-- --------------------------------------------------------

--
-- Table structure for table `orderhistory`
--

CREATE TABLE `orderhistory` (
  `id_order` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_driver` int(11) NOT NULL,
  `rating` int(1) NOT NULL,
  `feedback` text NOT NULL,
  `order_date` date NOT NULL,
  `pickup` varchar(255) NOT NULL,
  `dest` varchar(255) NOT NULL,
  `hidden_c` tinyint(1) NOT NULL DEFAULT '0',
  `hidden_d` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderhistory`
--

INSERT INTO `orderhistory` (`id_order`, `id_customer`, `id_driver`, `rating`, `feedback`, `order_date`, `pickup`, `dest`, `hidden_c`, `hidden_d`) VALUES
(1, 1, 4, 5, 'Mantap sekali bang! serasa menunggangi tikus!', '2017-10-07', 'Manado', 'Padang', 0, 0),
(2, 4, 3, 2, 'Dasar kucing lambat!', '2017-10-07', 'Surabaya', 'Shinjuku', 0, 0),
(3, 1, 3, 1, 'Ojek terlambat yang saya pernah naiki!', '2017-10-07', 'Shinjuku', 'Jakarta', 0, 0),
(4, 1, 5, 3, 'Ojeknya cepat, tapi bau busuk!', '2017-10-07', 'Makassar', 'Shibuya', 0, 0),
(5, 1, 4, 5, 'Wih abang emang paling best!', '2017-10-07', 'Bali', 'Pontianak', 0, 0),
(6, 2, 5, 2, 'Ojek jorok!', '2017-10-07', 'Brazil', 'Surabaya', 0, 0),
(7, 2, 4, 5, 'Abang I love u <3 <3', '2017-10-07', 'Denpasar', 'USA', 0, 0),
(8, 2, 3, 3, 'Kucingnya lucu walaupun lambat', '2017-10-07', 'Shinjuku', 'Inaba', 0, 0),
(9, 3, 4, 5, '', '2017-10-07', 'Seoul', 'Bandung', 0, 0),
(10, 3, 5, 1, 'Ojek belum mandi!', '2017-10-07', 'Brazil', 'Makassar', 0, 0),
(11, 4, 5, 3, 'Ini ojek atau mobil?', '2017-10-07', 'Jakarta', 'Bandung', 0, 0),
(12, 5, 3, 2, 'Kucing terjelek yang saya pernah temui!', '2017-10-07', 'Shinjuku', 'Uruguay', 0, 0),
(13, 5, 4, 5, 'Hebat bang bisa melintasi pulau dan samudera!', '2017-10-07', 'Carribean', 'Jambi', 0, 0),
(14, 2, 1, 5, 'Contoh ojek flabby yang baik!', '2017-10-07', 'Canada', 'Lampung', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `preferredlocation`
--

CREATE TABLE `preferredlocation` (
  `id` int(11) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preferredlocation`
--

INSERT INTO `preferredlocation` (`id`, `location`) VALUES
(1, 'Canada'),
(3, 'Akihabara'),
(3, 'Bali'),
(3, 'Bandung'),
(3, 'Jakarta'),
(3, 'Medan'),
(3, 'Shibuya'),
(3, 'Shinjuku'),
(3, 'Surabaya'),
(3, 'Yogyakarta'),
(4, 'Ambon'),
(4, 'Banda Aceh'),
(4, 'Bandar Lampung'),
(4, 'Bandung'),
(4, 'Banjarmasin'),
(4, 'Bengkulu'),
(4, 'Denpasar'),
(4, 'Gorontalo'),
(4, 'Jakarta'),
(4, 'Jambi'),
(4, 'Jayapura'),
(4, 'Kendari'),
(4, 'Kupang'),
(4, 'Makassar'),
(4, 'Mamuju'),
(4, 'Manado'),
(4, 'Manokwari'),
(4, 'Mataram'),
(4, 'Medan'),
(4, 'Padang'),
(4, 'Palangkaraya'),
(4, 'Palembang'),
(4, 'Palu'),
(4, 'Pangkalpinang'),
(4, 'Pekanbaru'),
(4, 'Pontianak'),
(4, 'Samarinda'),
(4, 'Semarang'),
(4, 'Serang'),
(4, 'Sofifi'),
(4, 'Surabaya'),
(4, 'Tanjung Pinang'),
(4, 'Tanjungselor'),
(4, 'Yogyakarta'),
(5, 'Bali'),
(5, 'Denpasar'),
(5, 'Jakarta'),
(5, 'Lampung'),
(5, 'Makassar'),
(5, 'Medan'),
(5, 'Pontianak'),
(5, 'Surabaya');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `phone_num` varchar(12) NOT NULL,
  `img_path` varchar(255) NOT NULL DEFAULT 'profiles/default.png',
  `fullname` varchar(20) NOT NULL,
  `is_driver` tinyint(1) NOT NULL DEFAULT '0',
  `star` decimal(2,1) NOT NULL DEFAULT '0.0',
  `vote` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `pass`, `phone_num`, `img_path`, `fullname`, `is_driver`, `star`, `vote`) VALUES
(1, 'gru_minion', 'despicable@me.com', '$2y$10$k3XJxjFdDRkZDjJKUe7CseZdRFod/k2Y8mGYPkTBUgoMKixRc3Q8m', '123456789', 'profiles/1.png', 'Felonius Gru', 0, '5.0', 1),
(2, 'impoppy', 'im@poppy.com', '$2y$10$eMb26jvX9Uu/Sd0nTGZzdOfbk9gRKaXCdIzhqY871bMyGYwMv5ZBm', '1234567890', 'profiles/2.png', 'Poppy', 0, '0.0', 0),
(3, 'gocat', 'gocat@gocat.com', '$2y$10$u1beeuPULQqrrXsupQxWxuPcHqOjNXZV03sr4Cs7VGLxzCQaoC3DK', '987654321', 'profiles/3.png', 'Go-Cat', 1, '2.0', 4),
(4, 'hellbiker', 'hell@biker.com', '$2y$10$.1o8ZsA1ieLCZMYFwOcWUOCevN79qPHZtn0RSRO20pFRiB2M8Lf9K', '8194672384', 'profiles/4.png', 'Hell Biker', 1, '5.0', 5),
(5, 'mater', 'mater@tow.car', '$2y$10$csPUTsZjWDxyQEDwFs2kyuLSAAQMUMNHNb5BqExlu/Jr2N0LP70CG', '32784623874', 'profiles/5.png', 'Mater Tow Car', 1, '2.3', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orderhistory`
--
ALTER TABLE `orderhistory`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `OrderHistory_fk0` (`id_customer`),
  ADD KEY `OrderHistory_fk1` (`id_driver`);

--
-- Indexes for table `preferredlocation`
--
ALTER TABLE `preferredlocation`
  ADD PRIMARY KEY (`id`,`location`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orderhistory`
--
ALTER TABLE `orderhistory`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderhistory`
--
ALTER TABLE `orderhistory`
  ADD CONSTRAINT `OrderHistory_fk0` FOREIGN KEY (`id_customer`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `OrderHistory_fk1` FOREIGN KEY (`id_driver`) REFERENCES `user` (`id`);

--
-- Constraints for table `preferredlocation`
--
ALTER TABLE `preferredlocation`
  ADD CONSTRAINT `PreferredLocation_fk0` FOREIGN KEY (`id`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
