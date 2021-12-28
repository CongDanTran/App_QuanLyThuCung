package Model;

import Model.TblPhieuGui;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T15:53:43")
@StaticMetamodel(TblHinhThuc.class)
public class TblHinhThuc_ { 

    public static volatile SingularAttribute<TblHinhThuc, String> loai;
    public static volatile SingularAttribute<TblHinhThuc, Long> maHinhThuc;
    public static volatile CollectionAttribute<TblHinhThuc, TblPhieuGui> tblPhieuGuiCollection;
    public static volatile SingularAttribute<TblHinhThuc, Double> gia;

}