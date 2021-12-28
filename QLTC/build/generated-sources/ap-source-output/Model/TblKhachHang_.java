package Model;

import Model.TblPhieuGui;
import Model.TblThuCungKyGui;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T15:53:43")
@StaticMetamodel(TblKhachHang.class)
public class TblKhachHang_ { 

    public static volatile SingularAttribute<TblKhachHang, String> diaChi;
    public static volatile SingularAttribute<TblKhachHang, Long> maKH;
    public static volatile SingularAttribute<TblKhachHang, Integer> sdt;
    public static volatile CollectionAttribute<TblKhachHang, TblThuCungKyGui> tblThuCungKyGuiCollection;
    public static volatile SingularAttribute<TblKhachHang, String> tenKH;
    public static volatile SingularAttribute<TblKhachHang, String> loai;
    public static volatile CollectionAttribute<TblKhachHang, TblPhieuGui> tblPhieuGuiCollection;

}