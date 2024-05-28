-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Bulan Mei 2024 pada 02.10
-- Versi server: 10.4.25-MariaDB
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gym`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `gym`
--

CREATE TABLE `gym` (
  `nama` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `nomor` varchar(50) NOT NULL,
  `lama` double NOT NULL,
  `biaya` double NOT NULL,
  `daftar` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gym`
--

INSERT INTO `gym` (`nama`, `gender`, `nomor`, `lama`, `biaya`, `daftar`) VALUES
('haha', 'laki-laki', '089765789', 2, 190000, '2024-05-27'),
('raka', 'Laki-Laki', '890654', 2, 190000, '2022-12-07'),
('raka putra', 'Laki-Laki', '89008090', 1, 95000, '2022-12-07'),
('rakasa', 'Laki-Laki', '89076', 2, 190000, '2022-12-07'),
('rul', 'laki-laki', '08123059', 2, 190000, '2023-06-09');

-- --------------------------------------------------------

--
-- Struktur dari tabel `riwayat`
--

CREATE TABLE `riwayat` (
  `nama` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `nomor` int(11) NOT NULL,
  `daftar` date NOT NULL,
  `habis` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `gym`
--
ALTER TABLE `gym`
  ADD PRIMARY KEY (`nama`);

--
-- Indeks untuk tabel `riwayat`
--
ALTER TABLE `riwayat`
  ADD PRIMARY KEY (`nama`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
