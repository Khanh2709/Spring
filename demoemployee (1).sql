-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 01, 2020 lúc 12:01 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `demoemployee`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `department`
--

CREATE TABLE `department` (
  `dep_id` int(11) NOT NULL,
  `dep_name` varchar(22) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `department`
--

INSERT INTO `department` (`dep_id`, `dep_name`) VALUES
(2, 'Tham dinh'),
(4, 'Maketing'),
(5, 'CEO'),
(6, 'Kho lanh'),
(7, 'Ho Tro'),
(8, 'Dau Tu'),
(28, 'Ho tro'),
(29, 'Kinh Doanh'),
(101, 'Ho Tro moi'),
(151, 'Kinh Doanh 1'),
(152, 'Kinh Doanh 1'),
(153, 'Kinh Doanh 1'),
(158, 'Kinh Doanh 1'),
(159, 'Kinh Doanh 1'),
(160, 'Kinh Doanh 1'),
(169, 'Kinh Doanh 2'),
(190, 'Doanh 3'),
(191, 'Doanh 3'),
(192, 'Xuat Nhap Khau');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `first_name` varchar(22) DEFAULT NULL,
  `last_name` varchar(22) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `dep_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `salary`, `dep_id`) VALUES
(8, 'Tran', 'Huyen', 888, 2),
(9, 'Ngoc', 'Huyen', 9999, 2),
(10, 'Hung', 'Dung', 12589, 4),
(11, 'Thanh', 'Huyen', 19599, 2),
(13, 'Trung', 'Thanh', 458, 2),
(14, 'Hoang', 'Tu', 1458111, 4),
(16, 'Hung', 'Dung', 12589, 4),
(17, 'ffff', 'Huyen', 888, 28),
(18, 'Ho', 'Huyen', 111, 29),
(19, 'Ngoc', 'Huyen', 9999, 2),
(22, 'Ho', 'Huyen', 111, 151),
(23, 'Ho', 'mi', 111, 151),
(24, 'Ho', 'Huyen', 111, 152),
(25, 'Ho', 'mi', 111, 152),
(26, 'Ho', 'Huyen', 111, 158),
(27, 'Ho', 'mi', 111, 158),
(28, 'Ho', 'Huyen', 111, 159),
(29, 'Ho', 'Huyen', 111, 160),
(30, 'Duc', 'Minh', 7889, 190),
(31, 'Duc', 'Minh', 7889, 191),
(32, 'Thuy', 'Nhung', 39744, 192);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dep_id`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fc_ss` (`dep_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `department`
--
ALTER TABLE `department`
  MODIFY `dep_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=193;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fc_ss` FOREIGN KEY (`dep_id`) REFERENCES `department` (`dep_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
