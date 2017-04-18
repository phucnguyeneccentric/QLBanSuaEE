package EntityBeans;

import EntityBeans.CtHoadon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-17T09:38:32")
@StaticMetamodel(HoaDon.class)
public class HoaDon_ { 

    public static volatile SingularAttribute<HoaDon, Date> ngayHD;
    public static volatile SingularAttribute<HoaDon, String> makhachhang;
    public static volatile SingularAttribute<HoaDon, String> sohoadon;
    public static volatile SingularAttribute<HoaDon, Double> trigia;
    public static volatile ListAttribute<HoaDon, CtHoadon> ctHoadonList;

}