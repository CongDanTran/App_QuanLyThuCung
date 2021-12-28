package Model;

import Model.TblChiTietPhieuGui;
import Model.TblDatCho;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T15:53:43")
@StaticMetamodel(TblChuong.class)
public class TblChuong_ { 

    public static volatile CollectionAttribute<TblChuong, TblDatCho> tblDatChoCollection;
    public static volatile SingularAttribute<TblChuong, String> trangThai;
    public static volatile SingularAttribute<TblChuong, Long> maChuong;
    public static volatile CollectionAttribute<TblChuong, TblChiTietPhieuGui> tblChiTietPhieuGuiCollection;
    public static volatile SingularAttribute<TblChuong, String> tenChuong;
    public static volatile SingularAttribute<TblChuong, String> loaiChuong;
    public static volatile SingularAttribute<TblChuong, Double> gia;

}