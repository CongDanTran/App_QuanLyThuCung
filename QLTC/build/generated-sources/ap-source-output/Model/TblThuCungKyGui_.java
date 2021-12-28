package Model;

import Model.TblChiTietPhieuGui;
import Model.TblNhatKyNuoi;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T15:53:43")
@StaticMetamodel(TblThuCungKyGui.class)
public class TblThuCungKyGui_ { 

    public static volatile SingularAttribute<TblThuCungKyGui, Long> maKH;
    public static volatile CollectionAttribute<TblThuCungKyGui, TblNhatKyNuoi> tblNhatKyNuoiCollection;
    public static volatile SingularAttribute<TblThuCungKyGui, String> hinhAnh;
    public static volatile SingularAttribute<TblThuCungKyGui, String> tinhTrangSK;
    public static volatile SingularAttribute<TblThuCungKyGui, String> trangThai;
    public static volatile SingularAttribute<TblThuCungKyGui, Long> maSoThuCung;
    public static volatile SingularAttribute<TblThuCungKyGui, String> tenKH;
    public static volatile SingularAttribute<TblThuCungKyGui, String> loai;
    public static volatile SingularAttribute<TblThuCungKyGui, String> giong;
    public static volatile CollectionAttribute<TblThuCungKyGui, TblChiTietPhieuGui> tblChiTietPhieuGuiCollection;
    public static volatile SingularAttribute<TblThuCungKyGui, Double> canNang;

}