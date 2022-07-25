--DROP TABLE IF EXISTS `test2_db`.`medication_intake`;

CREATE TABLE `test2_db`.`medication_intake` (
  `id` bigint(20) NOT NULL,
  `month` varchar(45) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  `medicine01` varchar(255) DEFAULT NULL,
  `pieces01` double DEFAULT NULL,
  `dose01` double NOT NULL,
  `medicine02` varchar(255) DEFAULT NULL,
  `pieces02` double DEFAULT NULL,
  `dose02` double NOT NULL,
  `medicine03` varchar(255) DEFAULT NULL,
  `dose03` double NOT NULL,
  PRIMARY KEY (`id`)
  );

