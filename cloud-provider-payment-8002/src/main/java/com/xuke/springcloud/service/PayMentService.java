package com.xuke.springcloud.service;

import com.xuke.springcloud.entities.Payment;

public interface PayMentService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Tue Jun 16 19:55:38 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Tue Jun 16 19:55:38 GMT+08:00 2020
     */
    int insert(Payment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Tue Jun 16 19:55:38 GMT+08:00 2020
     */
    int insertSelective(Payment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Tue Jun 16 19:55:38 GMT+08:00 2020
     */
    Payment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Tue Jun 16 19:55:38 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(Payment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Tue Jun 16 19:55:38 GMT+08:00 2020
     */
    int updateByPrimaryKey(Payment record);
}
