import org.example.entity.SinhVien;
import org.example.service.SinhVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinhVienServiceTest {
    SinhVienService service;
    @BeforeEach
    public void setup() {
        service = new SinhVienService();
    }
    //test min
    @Test
    public void testDiemMin() {
        SinhVien sv = new SinhVien("PH123","THUY NGUYEN",20,9.5f,5,"PTPM");
        service.addSinhVien(sv);

        SinhVien sv2 = new SinhVien("PH123","THUY NGUYEN",20,0f,5,"PTPM");
        service.updateSinhVien(sv2);

        SinhVien result = service.getSinhVien("PH123");
        Assertions.assertEquals(0f,result.getDiemTrungBinh());
    }
    //test min+1
    @Test
    public void testDiemMinCong1() {
        SinhVien sv = new SinhVien("PH123","THUY NGUYEN",20,9.5f,5,"PTPM");
        service.addSinhVien(sv);

        SinhVien sv2 = new SinhVien("PH123","THUY NGUYEN",20,1f,5,"PTPM");
        service.updateSinhVien(sv2);

        SinhVien result = service.getSinhVien("PH123");
        Assertions.assertEquals(1f,result.getDiemTrungBinh());
    }
    @Test
    public void testDiemMinTru1() {
        SinhVien sv = new SinhVien("PH123","THUY NGUYEN",20,-1f,5,"PTPM");
        Assertions.assertThrows(IllegalArgumentException.class,()->service.updateSinhVien(sv));
    }
    //max
    @Test
    public void testDiemMax() {
        SinhVien sv = new SinhVien("PH123","THUY NGUYEN",20,9.5f,5,"PTPM");
        service.addSinhVien(sv);

        SinhVien sv2 = new SinhVien("PH123","THUY NGUYEN",20,10f,5,"PTPM");
        service.updateSinhVien(sv2);

        SinhVien result = service.getSinhVien("PH123");
        Assertions.assertEquals(10f,result.getDiemTrungBinh());
    }
    @Test
    public void testDiemMaxTru1() {
        SinhVien sv = new SinhVien("PH123","THUY NGUYEN",20,9.5f,5,"PTPM");
        service.addSinhVien(sv);

        SinhVien sv2 = new SinhVien("PH123","THUY NGUYEN",20,9f,5,"PTPM");
        service.updateSinhVien(sv2);

        SinhVien result = service.getSinhVien("PH123");
        Assertions.assertEquals(9f,result.getDiemTrungBinh());
    }
    @Test
    public void testDiemMaxCong1() {
        SinhVien sv = new SinhVien("PH123","THUY NGUYEN",20,11f,5,"PTPM");
        Assertions.assertThrows(IllegalArgumentException.class,()->service.updateSinhVien(sv));
    }
}
