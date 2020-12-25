import org.junit.Test

class MyTest {

  def test(): Unit = assert(false)

  @Test
  def testName(): Unit = assert(true)

  @Test
  def testCase1(): Unit = {
  }

  @Test(timeout = 1000)
  def testCase2(): Unit = {
  }

  @Test(expected = classOf[RuntimeException])
  def testCase3(): Unit = {
    throw new RuntimeException()
  }

  @Test(timeout = 1000, expected = classOf[RuntimeException])
  def testCase4(): Unit = {
    throw new RuntimeException()
  }
}