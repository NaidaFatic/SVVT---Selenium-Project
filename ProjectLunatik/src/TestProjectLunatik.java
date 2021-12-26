import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestProjectLunatik {
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/Users/Naida/Downloads/chromedriver_win32/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		baseUrl = "https://lunatik.io/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

	@Test
	void testHomePage() throws InterruptedException {
		webDriver.get(baseUrl);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(3));
		
		String title = webDriver.getTitle();
		assertEquals("Lunatik - Wear what you love", title);
		
		WebElement pocetna = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[1]/a"));
		assertEquals("Početna", pocetna.getText());
		
		pocetna.click();
		Thread.sleep(5000);
		String urlPocetna = webDriver.getCurrentUrl();
		assertEquals(baseUrl, urlPocetna);
		
		WebElement posljednjeDodano = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[2]/a")));
		assertEquals("Posljednje dodano", posljednjeDodano.getText());
		
		posljednjeDodano.click();
		Thread.sleep(5000);
		String urlPosljednjeDodano = webDriver.getCurrentUrl();
		assertEquals(baseUrl+"collections/nova-kolekcija", urlPosljednjeDodano);
		
		WebElement sveNaSnizenju = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div/header/div/div[2]/ul/li[3]/a")));
		assertEquals("Sve na sniženju", sveNaSnizenju.getText());
		
		sveNaSnizenju.click();
		Thread.sleep(5000);
		String urlsveNaSnizenju = webDriver.getCurrentUrl();
		assertEquals(baseUrl+"collections/snizenje", urlsveNaSnizenju);
		
		WebElement anime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div/header/div/div[2]/ul/li[4]/a")));
		assertEquals("Anime", anime.getText());
		
		anime.click();
		Thread.sleep(5000);
		String urlAnime = webDriver.getCurrentUrl();
		assertEquals(baseUrl+"collections/anime", urlAnime);
		
		WebElement zene = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div/header/div/div[2]/ul/li[5]/a")));
		assertEquals("Žene", zene.getText());
		
		zene.click();
		Thread.sleep(5000);
		String urlZene = webDriver.getCurrentUrl();
		assertEquals(baseUrl+"#", urlZene);
		
		WebElement muskarci =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[6]/a")));
		assertEquals("Muškarci", muskarci.getText());
		
		muskarci.click();
		Thread.sleep(5000);
		String urlMuskarci = webDriver.getCurrentUrl();
		assertEquals(baseUrl+"#", urlMuskarci);
		
		WebElement wishlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[7]/a")));
		assertEquals("Wishlist ❤️", wishlist.getText());
		
		wishlist.click();
		Thread.sleep(5000);
		String urlWishlist = webDriver.getCurrentUrl();
		assertEquals(baseUrl+"pages/wishlist-1", urlWishlist);
	}

}
