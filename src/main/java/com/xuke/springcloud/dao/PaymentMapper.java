package com.xuke.springcloud.dao;

import com.xuke.springcloud.entities.Payment;

public interface PaymentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Wed Jun 17 21:13:09 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Wed Jun 17 21:13:09 GMT+08:00 2020
     */
    int insert(Payment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Wed Jun 17 21:13:09 GMT+08:00 2020
     */
    int insertSelective(Payment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Wed Jun 17 21:13:09 GMT+08:00 2020
     */
    Payment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Wed Jun 17 21:13:09 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(Payment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbggenerated Wed Jun 17 21:13:09 GMT+08:00 2020
     */
    int updateByPrimaryKey(Payment record);
}