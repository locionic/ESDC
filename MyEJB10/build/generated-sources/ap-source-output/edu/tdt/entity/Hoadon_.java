package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Hoadon.class)
public abstract class Hoadon_ {

	public static volatile SingularAttribute<Hoadon, Date> date;
	public static volatile SingularAttribute<Hoadon, Nhanvien> idNv;
	public static volatile SingularAttribute<Hoadon, Long> money;
	public static volatile CollectionAttribute<Hoadon, Hdhh> hdhhCollection;
	public static volatile SingularAttribute<Hoadon, Long> id;

}

