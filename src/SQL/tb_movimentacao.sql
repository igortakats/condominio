CREATE TABLE `tb_movimentacao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `cd_unidade_residencial` int(11) DEFAULT NULL,
  `nm_ano_referencia` int(11) DEFAULT NULL,
  `nm_mes_referencia` varchar(45) DEFAULT NULL,
  `dt_data_lancamento` datetime DEFAULT NULL,
  `vl_valor` decimal(10,0) DEFAULT NULL,
  `nm_tipo_lancamento` varchar(45) DEFAULT NULL,
  `nm_registro_origemm` varchar(500) DEFAULT NULL,
  `dt_data_criacao` datetime DEFAULT NULL,
  `dt_data_alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=utf8;