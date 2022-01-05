import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
class TestProjectLunatik {
	private static WebDriver webDriver;
	private static String baseUrl;
	private static  WebDriverWait wait;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/Users/Naida/Downloads/chromedriver_win32/chromedriver.exe");
		webDriver = new ChromeDriver();
		wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		webDriver.manage().window().maximize();
		baseUrl = "https://lunatik.io/";
	}
	
	@BeforeEach
	void setUpBeforEach() {
		webDriver.get(baseUrl);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

//	@Test
//	@Order(1)
//	void testHomePage() throws InterruptedException {
//		
//		String title = webDriver.getTitle();
//		assertEquals("Lunatik - Wear what you love", title);
//
//		WebElement pocetna = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[1]/a"));
//		assertEquals("Početna", pocetna.getText());
//
//		pocetna.click();
//		Thread.sleep(5000);
//		String urlPocetna = webDriver.getCurrentUrl();
//		assertEquals(baseUrl, urlPocetna);
//
//		WebElement posljednjeDodano = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[2]/a")));
//		assertEquals("Posljednje dodano", posljednjeDodano.getText());
//
//		posljednjeDodano.click();
//		Thread.sleep(5000);
//		String urlPosljednjeDodano = webDriver.getCurrentUrl();
//		assertEquals(baseUrl+"collections/nova-kolekcija", urlPosljednjeDodano);
//
//		WebElement sveNaSnizenju = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sve na sniženju")));
//		assertEquals("Sve na sniženju", sveNaSnizenju.getText());
//
//		sveNaSnizenju.click();
//		Thread.sleep(5000);
//		String urlsveNaSnizenju = webDriver.getCurrentUrl();
//		assertEquals(baseUrl+"collections/snizenje", urlsveNaSnizenju);
//
//		WebElement anime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Anime")));
//		assertEquals("Anime", anime.getText());
//
//		anime.click();
//		Thread.sleep(5000);
//		String urlAnime = webDriver.getCurrentUrl();
//		assertEquals(baseUrl+"collections/anime", urlAnime);
//
//		WebElement zene = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Žene")));
//		assertEquals("Žene", zene.getText());
//
//		zene.click();
//		Thread.sleep(5000);
//		String urlZene = webDriver.getCurrentUrl();
//		assertEquals(baseUrl+"#", urlZene);
//
//		WebElement muskarci =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Muškarci")));
//		assertEquals("Muškarci", muskarci.getText());
//
//		muskarci.click();
//		Thread.sleep(5000);
//		String urlMuskarci = webDriver.getCurrentUrl();
//		assertEquals(baseUrl+"#", urlMuskarci);
//
//		WebElement wishlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[7]/a")));
//		assertEquals("Wishlist ❤️", wishlist.getText());
//
//		wishlist.click();
//		Thread.sleep(5000);
//		String urlWishlist = webDriver.getCurrentUrl();
//		assertEquals(baseUrl+"pages/wishlist-1", urlWishlist);
//	}
//	
//	
//	@Test
//	@Order(2)
//	void testCollectionsOnHomepage() throws InterruptedException {
//		
//		String title = webDriver.getTitle();
//		assertEquals("Lunatik - Wear what you love", title);
//		
//		WebElement kosuljeIBluze = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[1]/a/div[2]/div"));
//		Actions actions = new Actions(webDriver);
//		actions.moveToElement(kosuljeIBluze);
//		actions.perform();
//		Thread.sleep(5000);
//		assertEquals("KOŠULJE I BLUZE", kosuljeIBluze.getAttribute("innerText"));
//		
//		kosuljeIBluze.click();
//		Thread.sleep(5000);
//		String currentUrl = webDriver.getCurrentUrl();
//		assertEquals(baseUrl + "collections/ko-ulje", currentUrl);
//		webDriver.navigate().back();
//		Thread.sleep(5000);
//		
//		WebElement MajiceITopovi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[2]/a/div[2]/div"));
//		assertEquals("MAJICE I TOPOVI", MajiceITopovi.getAttribute("innerText"));
//		MajiceITopovi.click();
//		Thread.sleep(5000);
//		currentUrl = webDriver.getCurrentUrl();
//		assertEquals(baseUrl + "collections/majice", currentUrl);
//		webDriver.navigate().back();
//		Thread.sleep(5000);
//		
//		WebElement JakneISakoi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[3]/a/div[2]/div"));
//		assertEquals("JAKNE I SAKOI", JakneISakoi.getAttribute("innerText"));
//		JakneISakoi.click();
//		Thread.sleep(5000);
//		currentUrl = webDriver.getCurrentUrl();
//		assertEquals(baseUrl + "collections/jakne", currentUrl);
//		webDriver.navigate().back();
//		Thread.sleep(5000);
//		
//		WebElement DvodijelniSetovi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[4]/a/div[2]/div"));
//		assertEquals("DVODJELNI SETOVI", DvodijelniSetovi.getAttribute("innerText"));
//		DvodijelniSetovi.click();
//		Thread.sleep(5000);
//		currentUrl = webDriver.getCurrentUrl();
//		assertEquals(baseUrl + "collections/dvodjelni-setovi", currentUrl);
//		webDriver.navigate().back();
//		Thread.sleep(5000);
//		
//		WebElement Dukse = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[5]/a/div[2]/div"));
//		assertEquals("DUKSE", Dukse.getAttribute("innerText"));
//		Dukse.click();
//		Thread.sleep(5000);
//		currentUrl = webDriver.getCurrentUrl();
//		assertEquals(baseUrl + "collections/dukse", currentUrl);
//		webDriver.navigate().back();
//		Thread.sleep(5000);
//		
//		WebElement Dzemperi = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-16170889646a137eeb\"]/div/div/div[2]/div/div[6]/a/div[2]/div"));
//		assertEquals("DŽEMPERI I KARDIGANI", Dzemperi.getAttribute("innerText"));
//		Dzemperi.click();
//		Thread.sleep(5000);
//		currentUrl = webDriver.getCurrentUrl();
//		assertEquals(baseUrl + "collections/d-emperi", currentUrl);
//	}
//	
//	@Order(3)
//	@Test
//	void testSearch() throws InterruptedException {
//		
//		WebElement SearchButton = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div[1]/div[2]/header/div/div[1]/div[1]/div/a")));
//		
//		SearchButton.click();
//		WebElement SearchInput = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.name("q")));
//		SearchInput.sendKeys("majica");
//		WebElement SearchSubmit = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchModal\"]/div/div/div/form/button")));
//		SearchSubmit.click();
//		
//		WebElement SearchResult = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/div[1]")));
//		List<WebElement> child = SearchResult.findElements(By.xpath(".//*"));
//		assertTrue(child.size()>1);
//		
//		SearchButton = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div/header/div/div[1]/div[1]/div/a")));
//		SearchButton.click();
//		SearchInput = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.name("q")));
//		SearchInput.sendKeys("aass" + Keys.ENTER);
//		SearchResult = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/div[1]")));
//		child = SearchResult.findElements(By.xpath(".//*"));
//		assertFalse(child.size()>1);
//	}
//	
//	@Test
//	@Order(4)
//	void testItemSorting() throws InterruptedException {
//		
//		WebElement posljednjeDodano = wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[2]/a")));
//		posljednjeDodano.click();
//		
//		Select sortSelect = new Select(
//				wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"SortBy\"]")))
//				);
//		
//		WebElement Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		List<WebElement> childs1 = Items.findElements(By.xpath(".//*"));
//		
//		sortSelect.selectByValue("best-selling");
//		
//		Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		List<WebElement> childs2 = Items.findElements(By.xpath(".//*"));
//		
//		assertNotEquals(childs1, childs2);
//		childs1 = new ArrayList<>(childs2);
//		
//		sortSelect = new Select(
//				wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"SortBy\"]")))
//				);
//		
//		sortSelect.selectByValue("title-ascending");
//		
//		Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		childs2 = Items.findElements(By.xpath(".//*"));
//		assertNotEquals(childs1, childs2);
//		childs1 = new ArrayList<>(childs2);
//		
//		sortSelect = new Select(
//				wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"SortBy\"]")))
//				);
//		
//		sortSelect.selectByValue("title-descending");
//		
//		Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		childs2 = Items.findElements(By.xpath(".//*"));
//		assertNotEquals(childs1, childs2);
//		childs1 = new ArrayList<>(childs2);
//		
//		sortSelect = new Select(
//				wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"SortBy\"]")))
//				);
//		
//		sortSelect.selectByValue("price-ascending");
//		
//		Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		childs2 = Items.findElements(By.xpath(".//*"));
//		assertNotEquals(childs1, childs2);
//		childs1 = new ArrayList<>(childs2);
//		
//		sortSelect = new Select(
//				wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"SortBy\"]")))
//				);
//		
//		sortSelect.selectByValue("price-descending");
//		
//		Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		childs2 = Items.findElements(By.xpath(".//*"));
//		assertNotEquals(childs1, childs2);
//		childs1 = new ArrayList<>(childs2);
//		
//		sortSelect = new Select(
//				wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"SortBy\"]")))
//				);
//		
//		sortSelect.selectByValue("created-ascending");
//		
//		Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		childs2 = Items.findElements(By.xpath(".//*"));
//		assertNotEquals(childs1, childs2);
//		childs1 = new ArrayList<>(childs2);
//		
//		sortSelect = new Select(
//				wait
//				.until(ExpectedConditions
//						.visibilityOfElementLocated(By
//								.xpath("//*[@id=\"SortBy\"]")))
//				);
//		
//		sortSelect.selectByValue("created-descending");
//		
//		Items = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]")));
//		childs2 = Items.findElements(By.xpath(".//*"));
//		assertNotEquals(childs1, childs2);
//		childs1 = new ArrayList<>(childs2);
//	}
//	
//	@Order(5)
//	@Test
//	void itemTest() throws InterruptedException {
//		
//		WebElement muskarci = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[6]/a"));
//
//		Actions action = new Actions(webDriver);
//		//Performing the mouse hover action on the target element.
//		action.moveToElement(muskarci).perform();
//		
//		WebElement nakit = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div/header/div/div[2]/ul/li[6]/ul/li[5]/a")));
//		action.moveToElement(nakit).perform();
//		
//		
//		WebElement prstenje = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[2]/ul/li[6]/ul/li[5]/ul/li[2]/a")));
//		prstenje.click();
//		
//		Thread.sleep(3000);
//		WebElement naziv = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/div[1]/div/header/h1"));
//		
//		assertEquals("MUŠKO PRSTENJE", naziv.getText());
//		
//		WebElement prsten = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div/div[1]/div/a")));
//		
//		WebElement cijena = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div/div[1]/div/a/div[2]/div[3]/span")));
//		
//		assertEquals("15,95 KM", cijena.getText());
//		
//		prsten.click();
//		
//		WebElement cijena2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product__price")));	
//		assertEquals("15,95 KM", cijena2.getText());
//		
//		WebElement dodajUKosaru = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add")));
//		dodajUKosaru.click();
//		Thread.sleep(5000);
//		
//		WebElement kosaraIkona = webDriver.findElement(By.className("cart-link__count"));
//		assertEquals("1", kosaraIkona.getText());
//		
//		WebElement zatvoriKorpu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("drawer__close-button")));
//		zatvoriKorpu.click();
//		
//		WebElement dodajUWhishlistu = webDriver.findElement(By.xpath("//*[@id=\"ZooomyList\"]"));
//		dodajUWhishlistu.click();
//		Thread.sleep(2000);
//		
//		WebElement ukloniIzWhishliste = webDriver.findElement(By.xpath("//*[@id=\"ZooomyList\"]/label/p"));
//		assertEquals("Ukloni iz Wishlist", ukloniIzWhishliste.getText());
//		
//		WebElement goBack = webDriver.findElement(By.xpath("//*[@id=\"MainContent\"]/div[4]/a"));
//		goBack.click();
//		
//		naziv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/div[1]/div/header/h1")));
//		assertEquals("MUŠKO PRSTENJE", naziv.getText());
//	}
//	
	/*
	@Order(6)
	@Test
	void recenzija() throws InterruptedException {
	
		webDriver.get(baseUrl+"collections/musko-prstenje/products/set-golden-black-maxi-prstenja");
		
		WebElement dodajRecenziju = webDriver.findElement(By.className("jdgm-write-rev-link"));
		dodajRecenziju.click();
		Thread.sleep(2000);
		
		Select ime = new Select (wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reviewer_name_format"))));
		ime.selectByValue("anonymous");
		
		WebElement email = webDriver.findElement(By.name("reviewer_email"));
		email.sendKeys("example@example.com");
		
		WebElement star = webDriver.findElement(By.xpath("//*[@id=\"judgeme_product_reviews\"]/div/div[1]/div[6]/form/div[3]/span/a[5]"));
		star.click();
		
		WebElement naslov = webDriver.findElement(By.name("review_title"));
		naslov.sendKeys("Nice");
		
		WebElement pregled = webDriver.findElement(By.name("review_body"));
		pregled.sendKeys("Looks cool");
		
		Thread.sleep(2000);
		
		WebElement posalji = webDriver.findElement(By.xpath("//*[@id=\"judgeme_product_reviews\"]/div/div[1]/div[6]/form/input"));
		posalji.click();
		
		Thread.sleep(2000);
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/div[1]/div/div/div/div[3]/div/div[1]/div[6]/form/div[1]/div")));
		assertEquals("Ovo polje je obavezno.",error.getText());
		
		Thread.sleep(5000);
		WebElement imeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reviewer_name")));
		imeInput.sendKeys("N.F");
		Thread.sleep(2000);
		
		posalji.click();
		Thread.sleep(5000);
	}*/
	/*
	@Order(7)
	@Test
	void successfullRegistration() throws InterruptedException {
		
		WebElement login = webDriver
				.findElement(By
						.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]"));
		login.click();
		WebElement register = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_register_link\"]")));
		register.click();
		
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[first_name]")));
		WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[last_name]")));
		WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[email]")));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[password]")));
		
		name.sendKeys("ime");
		lastName.sendKeys("prezime");
		mail.sendKeys("dadirel637@veb65.com");
		password.sendKeys("dummypassword");
		
		WebElement registerButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/p/input")));
		registerButton.click();
		
		Thread.sleep(5000);
		String currentUrl = webDriver.getCurrentUrl();
		
		assertEquals("https://lunatik.io/", currentUrl);
	}
//	*/
//	
//	@Order(8)
//	@Test
//	void mailAlreadyInUseTest() throws InterruptedException {
//		webDriver.get(baseUrl);
//		
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
//		
//		WebElement login = webDriver
//				.findElement(By
//						.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]"));
//		login.click();
//		WebElement register = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_register_link\"]")));
//		register.click();
//		
//		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[first_name]")));
//		WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[last_name]")));
//		WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[email]")));
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[password]")));
//		
//		name.sendKeys("ime");
//		lastName.sendKeys("prezime");
//		mail.sendKeys("dadirel637@veb65.com");
//		password.sendKeys("dummypassword");
//		
//		WebElement registerButton = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/p/input")));
//		registerButton.click();
//		
//		WebElement errorPrompt = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/div/ul/li")));
//		
//		assertEquals("Već postoji račun sa ovim email-om. Ukoliko je račun vaš restuj lozinku", errorPrompt.getAttribute("innerText"));
//	
//		wait
//		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/div/ul/li/a"))).click();
//		
//		assertEquals("https://lunatik.io/account/register", webDriver.getCurrentUrl());
//	}
//	
//	@Order(9)
//	@Test
//	void registrationFormValidationTest() throws InterruptedException {
//		
//		WebElement login = webDriver
//				.findElement(By
//						.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]"));
//		login.click();
//		WebElement register = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_register_link\"]")));
//		register.click();
//		
//		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[first_name]")));
//		WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[last_name]")));
//		WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[email]")));
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[password]")));
//		
//		name.sendKeys("ime");
//		lastName.sendKeys("prezime");
//		
//		WebElement registerButton = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/p/input")));
//		registerButton.click();
//		
//		WebElement errorPrompt = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/div/ul")));
//		List<WebElement> values = errorPrompt.findElements(By.tagName("li"));
//		
//		assertEquals("Lozinka ne može biti prazno.", values.get(0).getText());
//		assertEquals("Email ne može biti prazno.", values.get(1).getText());
//		
//		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[password]")));
//		password.sendKeys("dummypassword");
//		register = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/p/input")));
//		register.click();
//		Thread.sleep(5000);
//		errorPrompt = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/div/ul")));
//		values = errorPrompt.findElements(By.tagName("li"));
//		Thread.sleep(5000);
//		assertEquals("Email ne može biti prazno.", values.get(0).getText());
//		
//		mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[email]")));
//		mail.sendKeys("someemail@gmail.com");
//		register = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/p/input")));
//		register.click();
//		Thread.sleep(5000);
//		errorPrompt = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/div/ul")));
//		values = errorPrompt.findElements(By.tagName("li"));
//		Thread.sleep(5000);
//		assertEquals("Lozinka ne može biti prazno.", values.get(0).getText());
//		
//		mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[email]")));
//		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[password]")));
//		mail.sendKeys("someemail@gmail.coma");
//		password.sendKeys("dummypassword");
//		register = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/p/input")));
//		register.click();
//		Thread.sleep(5000);
//		errorPrompt = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_customer\"]/div/ul")));
//		values = errorPrompt.findElements(By.tagName("li"));
//		Thread.sleep(5000);
//		assertEquals("Email contains an invalid domain name.", values.get(0).getText());
//	}
//	
//	@Order(10)
//	@Test 
//	void loginTestFail() throws InterruptedException {
//		
//		WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]")));
//		loginButton.click();
//		
//		WebElement email  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerEmail")));
//		
//		email.sendKeys("someemail@gmail.coma");
//		
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerPassword")));
//		
//		password.sendKeys("dummypassword");
//		
//		Thread.sleep(2000);
//		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div/div[2]/form/p[1]/input")));
//		login.click();		
//		Thread.sleep(8000);
//		
//		WebElement pogresnoText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_login\"]/div[1]/ul/li")));
//		
//		assertEquals("E-Pošta ili lozinka nisu ispravni.", pogresnoText.getText());
//	}
//	
//	@Order(11)
//	@Test 
//	void loginTest() throws InterruptedException {
//		
//		WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]")));
//		loginButton.click();
//		
//		WebElement email  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerEmail")));
//		
//		email.sendKeys("dadirel637@veb65.com");
//		
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerPassword")));
//		
//		password.sendKeys("dummypassword");
//		
//		Thread.sleep(2000);
//		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div/div[2]/form/p[1]/input")));
//		login.click();		
//		Thread.sleep(8000);
//		
//		assertEquals("https://lunatik.io/account", webDriver.getCurrentUrl());
//	}
//	
//	@Order(12)
//	@Test 
//	void wishlist() throws InterruptedException {
//		
//		WebElement anime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#shopify-section-header > div:nth-child(3) >"
//				+ " div.header-wrapper > div.site-header-sticky > header > div > div.text-center > ul > li:nth-child(4) > a")));
//		anime.click();
//		
//		WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[2]/span[4]/a")));
//		next.click();
//		
//		Thread.sleep(2000);
//		
//		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
//		jse.executeScript("window.scrollBy(0,250)");
//		WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]/div[7]/div/a/div[1]")));
//		item.click();	
//		
//		Thread.sleep(2000);
//		WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("zooomypwishmsg")));
//		add.click();
//		Thread.sleep(2000);
//		
//		WebElement wishlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Wishlist")));
//		wishlist.click();
//		Thread.sleep(2000);
//		
//		WebElement price2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("zprice")));
//		Thread.sleep(2000);
//		
//		assertEquals("39.95", price2.getText());
//		
//		/*Select numberOfItems = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"zqtyn-6621271064611\"]"))));
//		numberOfItems.selectByIndex(6);*/
//		
//		WebElement kupiOdmah = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("addcartbtn")));
//		kupiOdmah.click();
//		
//		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-link__count")));
//
//		assertEquals("1",cart.getText());
//	}
//	
//	@Order(13)
//	@Test
//	void addNewAddressTest() throws InterruptedException {
//		
//		WebElement loginButton = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By
//						.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]")));
//		loginButton.click();
//		
//		WebElement email  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerEmail")));
//		
//		email.sendKeys("dadirel637@veb65.com");
//		
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerPassword")));
//		
//		password.sendKeys("dummypassword");
//		
//		Thread.sleep(2000);
//		WebElement login = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div/div[2]/form/p[1]/input")));
//		login.click();		
//		
//		WebElement addresses = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[2]/p[2]/a")));
//		addresses.click();
//		
//		WebElement addAddress = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/header/a")));
//		addAddress.click();
//		
//		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[first_name]")));
//		WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[last_name]")));
//		WebElement company = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[company]")));
//		WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[address1]")));
//		WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[city]")));
//		Select kanton = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[country]"))));
//		WebElement zip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[zip]")));
//		WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[phone]")));
//		WebElement addressDefault = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address[default]")));
//		
//		firstName.sendKeys("Ime");
//		lastName.sendKeys("prezime");
//		company.sendKeys("IBU");
//		address.sendKeys("Dummy Address 18");
//		city.sendKeys("Sarajevo");
//		kanton.selectByIndex(0);
//		zip.sendKeys("71000");
//		phone.sendKeys("061061061");
//		addressDefault.click();
//
//		WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"address_form_new\"]/input[6]")));
//		
//		Thread.sleep(5000);
//		
//		submitButton.click();
//		WebElement addedAddress = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/p[2]")));
//		
//		assertEquals("Ime prezime\n"
//				+ "IBU\n"
//				+ "Dummy Address 18\n"
//				+ "71000 Sarajevo\n"
//				+ "Bosnia & Herzegovina", addedAddress.getText());
//	}
//	
//	  @Order(14)
//	  @Test
//	  void editAddressTest() throws InterruptedException {
//		
//		WebElement loginButton = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By
//						.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]")));
//		loginButton.click();
//		
//		WebElement email  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerEmail")));
//		
//		email.sendKeys("dadirel637@veb65.com");
//		
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerPassword")));
//		
//		password.sendKeys("dummypassword");
//		
//		Thread.sleep(2000);
//		WebElement login = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div/div[2]/form/p[1]/input")));
//		login.click();		
//		
//		WebElement addresses = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[2]/p[3]/a")));
//		addresses.click();
//		
//		String address1 = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/p[2]"))).getText();
//
//		WebElement editAdress = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/p[3]/button[1]")));
//		editAdress.click();
//		
//		Thread.sleep(5000);
//		
//		WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressAddress1_6597707628579\"]")));
//		address.sendKeys(Keys.BACK_SPACE+"12");
//
//		WebElement submitButton = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"address_form_6597707628579\"]/input[7]")));
//		submitButton.click();
//		
//		Thread.sleep(5000);
//		WebElement address2 = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/p[1]")));
//		
//		assertNotEquals(address1, address2.getText());
//	}
//	
//	
//	@Order(15)
//	@Test
//	void deleteAddress() throws InterruptedException {
//
//		WebElement loginButton = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By
//						.xpath("//*[@id=\"shopify-section-header\"]/div[2]/div[1]/div[2]/header/div/div[1]/div[3]/div/div/a[1]")));
//		loginButton.click();
//	
//		WebElement email  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerEmail")));
//	
//		email.sendKeys("dadirel637@veb65.com");
//	
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerPassword")));
//	
//		password.sendKeys("dummypassword");
//	
//		Thread.sleep(2000);
//		WebElement login = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div/div[2]/form/p[1]/input")));
//		login.click();		
//		
//		Thread.sleep(2000);
//		WebElement addressa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Pogledaj adrese (1)")));
//		addressa.click();
//		
//		WebElement obrisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/p[3]/button[2]")));
//		obrisi.click();
//		Thread.sleep(2000);
//		
//		//alert
//		webDriver.switchTo().alert().accept();
//		Thread.sleep(2000);
//		
//		Boolean addressObrisana = webDriver.findElement(By.xpath("//*[@id=\"AddressNewForm\"]")).isDisplayed();
//		
//		assertFalse(addressObrisana);
//	}

	
}
