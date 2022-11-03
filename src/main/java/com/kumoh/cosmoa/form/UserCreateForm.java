package com.kumoh.cosmoa.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	@Size(min = 3, max = 25)
    @NotEmpty(message = "�����ID�� �ʼ��׸��Դϴ�.")
    private String username;
	
	@NotEmpty(message = "�̸����� �ʼ��׸��Դϴ�.")
    @Email
    private String email;

    @NotEmpty(message = "��й�ȣ�� �ʼ��׸��Դϴ�.")
    private String password1;

    @NotEmpty(message = "��й�ȣ Ȯ���� �ʼ��׸��Դϴ�.")
    private String password2;
    
    @NotEmpty(message = "�г����� �ʼ��׸��Դϴ�.")
    private String nickname;
    
    @NotEmpty(message = "������ �ʼ��׸��Դϴ�.")
    private int gender;
    
    @NotEmpty(message = "���̴� �ʼ��׸��Դϴ�.")
    private int age;
}
