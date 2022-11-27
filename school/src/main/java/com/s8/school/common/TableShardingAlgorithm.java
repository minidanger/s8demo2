package com.s8.school.common;

import com.s8.commom.utils.SHAUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Slf4j
public class TableShardingAlgorithm implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {

        String tb_name = shardingValue.getLogicTableName()+"_";
        String acount = shardingValue.getValue();
        System.out.println("account ==== "+acount);
        BigInteger bigInteger = SHAUtils.encodeSHA(acount);
        BigInteger remainder = bigInteger.mod(new BigInteger("4"));
        tb_name = tb_name+remainder.toString();

        System.out.println("table name = "+tb_name);
        return tb_name;
    }
}
