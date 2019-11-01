package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Phieu.class)
public abstract class Phieu_ {

	public static volatile SingularAttribute<Phieu, Date> date;
	public static volatile SingularAttribute<Phieu, Nhanvien> idNv;
	public static volatile CollectionAttribute<Phieu, Hhp> hhpCollection;
	public static volatile SingularAttribute<Phieu, Nhacc> idNcc;
	public static volatile SingularAttribute<Phieu, Long> id;

}

