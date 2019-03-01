import com.how2java.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author:Mr.wang
 * @date:2019/2/28 0028 上午 10:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private CategoryService categoryService;
    @Test
    public void testAddTwo(){
        categoryService.deleteAll();
        categoryService.addTwo();
    }
}
