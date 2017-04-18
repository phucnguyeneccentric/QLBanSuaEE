package EntityBeans;

import EntityBeans.CtHoadon;
import EntityBeans.HangSua;
import EntityBeans.LoaiSua;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-17T09:38:32")
@StaticMetamodel(Sua.class)
public class Sua_ { 

    public static volatile SingularAttribute<Sua, String> loiich;
    public static volatile SingularAttribute<Sua, String> masua;
    public static volatile SingularAttribute<Sua, String> tensua;
    public static volatile SingularAttribute<Sua, Integer> dongia;
    public static volatile SingularAttribute<Sua, LoaiSua> maloaisua;
    public static volatile SingularAttribute<Sua, Integer> trongluong;
    public static volatile SingularAttribute<Sua, String> tPDinhDuong;
    public static volatile SingularAttribute<Sua, String> hinh;
    public static volatile SingularAttribute<Sua, HangSua> mahangsua;
    public static volatile ListAttribute<Sua, CtHoadon> ctHoadonList;

}