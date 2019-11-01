package edu.tdt.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Taikhoan.class)
public abstract class Taikhoan_ {

	public static volatile SingularAttribute<Taikhoan, String> password;
	public static volatile SingularAttribute<Taikhoan, Long> idNv;
	public static volatile SingularAttribute<Taikhoan, Nhanvien> nhanvien;
	public static volatile SingularAttribute<Taikhoan, String> name;
	public static volatile SingularAttribute<Taikhoan, Vitri> idVt;

}

