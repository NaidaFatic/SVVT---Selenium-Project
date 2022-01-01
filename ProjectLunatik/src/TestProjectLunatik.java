import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	@Test
	void testCollectionsOnHomepage() throws InterruptedException {
		webDriver.get(baseUrl);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(3));
		
		String title = webDriver.getTitle();
		assertEquals("Lunatik - Wear what you love", title);
		
		WebElement kosuljeIBluze = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[1]/a/div[2]/div"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(kosuljeIBluze);
		actions.perform();
		Thread.sleep(5000);
		assertEquals("KOŠULJE I BLUZE", kosuljeIBluze.getAttribute("innerText"));
		
		kosuljeIBluze.click();
		Thread.sleep(5000);
		String currentUrl = webDriver.getCurrentUrl();
		assertEquals(baseUrl + "collections/ko-ulje", currentUrl);
		webDriver.navigate().back();
		Thread.sleep(5000);
		
		WebElement MajiceITopovi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[2]/a/div[2]/div"));
		assertEquals("MAJICE I TOPOVI", MajiceITopovi.getAttribute("innerText"));
		MajiceITopovi.click();
		Thread.sleep(5000);
		currentUrl = webDriver.getCurrentUrl();
		assertEquals(baseUrl + "collections/majice", currentUrl);
		webDriver.navigate().back();
		Thread.sleep(5000);
		
		WebElement JakneISakoi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[3]/a/div[2]/div"));
		assertEquals("JAKNE I SAKOI", JakneISakoi.getAttribute("innerText"));
		JakneISakoi.click();
		Thread.sleep(5000);
		currentUrl = webDriver.getCurrentUrl();
		assertEquals(baseUrl + "collections/jakne", currentUrl);
		webDriver.navigate().back();
		Thread.sleep(5000);
		
		WebElement DvodijelniSetovi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[4]/a/div[2]/div"));
		assertEquals("DVODJELNI SETOVI", DvodijelniSetovi.getAttribute("innerText"));
		DvodijelniSetovi.click();
		Thread.sleep(5000);
		currentUrl = webDriver.getCurrentUrl();
		assertEquals(baseUrl + "collections/dvodjelni-setovi", currentUrl);
		webDriver.navigate().back();
		Thread.sleep(5000);
		
		WebElement Dukse = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[5]/a/div[2]/div"));
		assertEquals("DUKSE", Dukse.getAttribute("innerText"));
		Dukse.click();
		Thread.sleep(5000);
		currentUrl = webDriver.getCurrentUrl();
		assertEquals(baseUrl + "collections/dukse", currentUrl);
		webDriver.navigate().back();
		Thread.sleep(5000);
		
		WebElement Dzemperi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[6]/a/div[2]/div"));
		assertEquals("DŽEMPERI I KARDIGANI", Dzemperi.getAttribute("innerText"));
		Dzemperi.click();
		Thread.sleep(5000);
		currentUrl = webDriver.getCurrentUrl();
		assertEquals(baseUrl + "collections/d-emperi", currentUrl);
	}
	
	@Test
	void testSearch() throws InterruptedException {
		webDriver.get(baseUrl);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		
		WebElement SearchButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[1]/div/a")));
		
		SearchButton.click();
		WebElement SearchInput = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.name("q")));
		SearchInput.sendKeys("majica");
		WebElement SearchSubmit = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchModal\"]/div/div/div/form/button")));
		SearchSubmit.click();
		
		WebElement SearchResult = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/div[1]")));
		List<WebElement> child = SearchResult.findElements(By.xpath(".//*"));
		assertTrue(child.size()>1);
		
		SearchButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div/header/div/div[1]/div[1]/div/a")));
		SearchButton.click();
		SearchInput = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.name("q")));
		SearchInput.sendKeys("aass" + Keys.ENTER);
		SearchResult = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/div[1]")));
		child = SearchResult.findElements(By.xpath(".//*"));
		assertFalse(child.size()>1);
	}
	
	@Test
	void testItemSorting() throws InterruptedException {
		webDriver.get(baseUrl);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		
		WebElement posljednjeDodano = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[2]/a")));
		posljednjeDodano.click();
		
		Select sortSelect = new Select(
				wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"SortBy\"]")))
				);
		
		WebElement Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		List<WebElement> childs1 = Items.findElements(By.xpath(".//*"));
		
		sortSelect.selectByValue("best-selling");
		
		Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		List<WebElement> childs2 = Items.findElements(By.xpath(".//*"));
		
		assertNotEquals(childs1, childs2);
		childs1 = new ArrayList<>(childs2);
		
		sortSelect = new Select(
				wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"SortBy\"]")))
				);
		
		sortSelect.selectByValue("title-ascending");
		
		Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		childs2 = Items.findElements(By.xpath(".//*"));
		assertNotEquals(childs1, childs2);
		childs1 = new ArrayList<>(childs2);
		
		sortSelect = new Select(
				wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"SortBy\"]")))
				);
		
		sortSelect.selectByValue("title-descending");
		
		Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		childs2 = Items.findElements(By.xpath(".//*"));
		assertNotEquals(childs1, childs2);
		childs1 = new ArrayList<>(childs2);
		
		sortSelect = new Select(
				wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"SortBy\"]")))
				);
		
		sortSelect.selectByValue("price-ascending");
		
		Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		childs2 = Items.findElements(By.xpath(".//*"));
		assertNotEquals(childs1, childs2);
		childs1 = new ArrayList<>(childs2);
		
		sortSelect = new Select(
				wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"SortBy\"]")))
				);
		
		sortSelect.selectByValue("price-descending");
		
		Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		childs2 = Items.findElements(By.xpath(".//*"));
		assertNotEquals(childs1, childs2);
		childs1 = new ArrayList<>(childs2);
		
		sortSelect = new Select(
				wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"SortBy\"]")))
				);
		
		sortSelect.selectByValue("created-ascending");
		
		Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		childs2 = Items.findElements(By.xpath(".//*"));
		assertNotEquals(childs1, childs2);
		childs1 = new ArrayList<>(childs2);
		
		sortSelect = new Select(
				wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By
								.xpath("//*[@id=\"SortBy\"]")))
				);
		
		sortSelect.selectByValue("created-descending");
		
		Items = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
		childs2 = Items.findElements(By.xpath(".//*"));
		assertNotEquals(childs1, childs2);
		childs1 = new ArrayList<>(childs2);
	}

}
