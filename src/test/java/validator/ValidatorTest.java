package validator;

import by.shibaev.shape.validator.ShapeValidator;
import by.shibaev.shape.validator.impl.SphereValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {

    ShapeValidator validator = new SphereValidator();

    @DataProvider(name = "true_data")
    public Object[] positiveData(){
        return new Object[]{"s 1 2 3 4 5"};
    }

    @DataProvider(name = "false_data")
    public Object[] negativeData(){
        return new Object[]{"s 5 4 3 2", "s 1 -2 3 4 5","s -1 2 3 4 5"};
    }


    @Test(dataProvider = "true_data")
    public void paramPositiveTest(String line){
        assertTrue(validator.isParamsValid(line));
    }

    @Test(dataProvider = "false_data")
    public void paramNegativeTest(String line){
        assertFalse(validator.isParamsValid(line));
    }
}
