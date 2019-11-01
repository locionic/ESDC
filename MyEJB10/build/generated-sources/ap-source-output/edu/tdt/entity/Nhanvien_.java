package edu.tdt.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Nhanvien.class)
public abstract class Nhanvien_ {

	public static volatile SingularAttribute<Nhanvien, String> address;
	public static volatile SingularAttribute<Nhanvien, String> phone;
	public static volatile SingularAttribute<Nhanvien, Taikhoan> taikhoan;
	public static volatile CollectionAttribute<Nhanvien, Phieu> phieuCollection;
	public static volatile CollectionAttribute<Nhanvien, Hoadon> hoadonCollection;
	public static volatile SingularAttribute<Nhanvien, String> name;
	public static volatile SingularAttribute<Nhanvien, Long> id;

}

