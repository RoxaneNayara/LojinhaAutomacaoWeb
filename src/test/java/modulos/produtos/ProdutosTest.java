package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Vou maximizar a tela
        this.navegador.manage().window().maximize();

        //Vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com o valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualA0() {
        //Fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com o valor maior que sete mil")
    public void testNaoEPermitidoRegistrarProdutoComValorAcimaDe7000(){
            //Fazer Login
            String mensagemApresentada = new LoginPage(navegador)
                    .informarOUsuario("admin")
                    .informarASenha("admin")
                    .submeterFormularioDeLogin()
                    .acessarFormularioAdicaoNovoProduto()
                    .informarNomeDoProduto("Iphone")
                    .informarValorDoProduto("700001")
                    .informarCoresDoProduto("preto,prata")
                    .submeterFormularioDeAdicaoComErro()
                    .capturarMensagemApresentada();

            Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

        }

        @Test
    @DisplayName("Posso adicionar produtos que estejam no limite de 0,01")
    public void testPossoAdicionaProdutosComValorDeUmCentavo(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("TV LCD")
                .informarValorDoProduto("001")
                .informarCoresDoProduto("preto,prata")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

            Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

        }

        @Test
        @DisplayName("Posso adicionar produtos que estejam no limite de 7000,00")
        public void testPossoAdicionaProdutosComValorDeSeteMil() {
            String mensagemApresentada = new LoginPage(navegador)
                    .informarOUsuario("admin")
                    .informarASenha("admin")
                    .submeterFormularioDeLogin()
                    .acessarFormularioAdicaoNovoProduto()
                    .informarNomeDoProduto("Sound Bar")
                    .informarValorDoProduto("700000")
                    .informarCoresDoProduto("preto,prata")
                    .submeterFormularioDeAdicaoComSucesso()
                    .capturarMensagemApresentada();

            Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

        }

    @AfterEach
    public void afterEach() {
        //Vou fechar o navegador
        navegador.quit();
    }

    }
