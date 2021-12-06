package presenter.manager_system;

import org.junit.Before;
import org.junit.Test;

public class EditDeletePresenterTest {

    private EditDeletePresenter deleteDishByName;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        deleteDishByName = new EditDeletePresenter();
            }

    /**
     * Test the dishesInMenuAsString method
     */
    @Test
    public void deleteDishByName(){
        deleteDishByName.deleteDishByName("dish2");
    }

    /**
     * Test the increasePrice method
     */
    @Test
    public void increasePrice(){
        deleteDishByName.increasePrice("dish2");
    }

    /**
     * Test the decreasePrice method
     */
    @Test
    public void decreasePrice(){
        deleteDishByName.decreasePrice("dish2");
    }

    /**
     * Test the decreaseCalories
     */
    @Test
    public void decreaseCalories(){
        deleteDishByName.decreaseCalories("dish2");
    }

    /**
     * Test the increaseCalories
     */
    @Test
    public void increaseCalories(){
        deleteDishByName.increaseCalories("dish2");
    }
}
