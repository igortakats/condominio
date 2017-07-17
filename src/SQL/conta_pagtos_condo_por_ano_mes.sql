select ano, mes, count(anomes) as qtd_pagtos from
(select nm_ano_referencia as ano, nm_mes_referencia as mes, concat(nm_ano_referencia, nm_mes_referencia) as anomes
from tb_movimentacao order by nm_ano_referencia, nm_mes_referencia) as ref
group by ano, mes order by ano, mes ; 