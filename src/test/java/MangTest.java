import org.example.entity.Mang;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MangTest {
    Mang entity = new Mang();
    //test ky thuat bien
    @Test
    public void testBienMin() {
        int mongMuon = 1010;
        int thucTe=entity.tinhTong(new int[] {1,2,3,4,1000});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    //test min+1
    @Test
    public void testBienMinCong1() {
        int mongMuon = 1011;
        int thucTe=entity.tinhTong(new int[] {2,2,3,4,1000});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    //test max
    @Test
    public void testBienMax() {
        int mongMuon = 1001;
        int thucTe=entity.tinhTong(new int[] {1,1000});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    //test max-1
    @Test
    public void testBienMaxTru1() {
        int mongMuon = 1000;
        int thucTe=entity.tinhTong(new int[] {1,999});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    //test ngoai le min-1
    @Test
    public void testBienMinTru1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> entity.tinhTong(new int[]{0,2,3,4,1000}));
    }
    //test ngoai le max+1
    @Test
    public void testBienMaxCong1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> entity.tinhTong(new int[]{1,2,3,4,1001}));
    }
}
