package cn.vince.practice.springBoot.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserBean {

    private String name;

    private Integer age;
}
