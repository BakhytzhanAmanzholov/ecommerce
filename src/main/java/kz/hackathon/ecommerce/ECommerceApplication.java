package kz.hackathon.ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.hackathon.ecommerce.models.Answer;
import kz.hackathon.ecommerce.models.Product;
import kz.hackathon.ecommerce.models.Survey;
import kz.hackathon.ecommerce.services.AnswerService;
import kz.hackathon.ecommerce.services.ProductService;
import kz.hackathon.ecommerce.services.SurveyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ECommerceApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ProductService productService, SurveyService surveyService, AnswerService answerService) {
//        return args -> {
//            Product normalSkin = productService.save(
//                    Product.builder()
//                            .title("Clarins Multi Active Revitalizing Night cream")
//                            .description("Ночной крем для нормальной и комбинированной кожи")
//                            .artifact("285083")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//            Product drySkin = productService.save(
//                    Product.builder()
//                            .title("Edute Soon Jung Увлажняющий эмульсия")
//                            .description("эмульсия для чувствительной и поврежденной кожи")
//                            .artifact("470615")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//            Product combiSkin = productService.save(
//                    Product.builder()
//                            .title("CeraVe Moisturising cream")
//                            .description("Увлажняющий крем Vanicream ™ восстанавливает и поддерживает нормальный уровень влажности. Он столь же нежен, сколь и эффективен даже для самой нежной кожи.")
//                            .artifact("30016")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//            Product sensitiveSkin = productService.save(
//                    Product.builder()
//                            .title("Dr. Althea Resveratoral 345 NA Intensive Repair Cream")
//                            .description("Восстанавливающий крем с ресвератролом сокращает выраженность мимических морщин и заметно разглаживает кожные заломы, ускоряет процессы регенерации и обновления кожи, повышает эластичность и укрепляет эпидермис.")
//                            .artifact("00963")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//// след тест
//
//            Product youngSkin = productService.save(
//                    Product.builder()
//                            .title("Lagom Cellus Mist Toner")
//                            .description("Отличное средство для увлажнения, тонизирования и восстановления гидролипидного баланса эпидермиса.")
//                            .artifact("544014")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//            Product oldSkin = productService.save(
//                    Product.builder()
//                            .title("Elemis Pro-Collagen Marine Cream")
//                            .description("Крем для лица Морские водоросли Про-Коллаген")
//                            .artifact("727")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
////            sled
//
//            Product extended = productService.save(
//                    Product.builder()
//                            .title("Cosrx Full Fit")
//                            .description("Легкий крем с экстрактом прополиса")
//                            .artifact("45103")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//            Product normal = productService.save(
//                    Product.builder()
//                            .title("OLEHENRISKEN Truth Barier Booster Orange Ferment Vitamin C Essence")
//                            .description("Улучшающая уход за кожей эссенция с витамином С")
//                            .artifact("8809030312")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
////            sled
//
//            Product without = productService.save(
//                    Product.builder()
//                            .title("Huggee All-in-one Cream")
//                            .description("Универсальный крем для лица с лактобактериями HYGGEE All-In-One Cream активно увлажняет и питает кожу")
//                            .artifact("8809030730312")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//            Product with = productService.save(
//                    Product.builder()
//                            .title("Farmacy 10% Waterless Vitamin C")
//                            .description("Сыворотка с 10% витамином С, которая заметно осветляет")
//                            .artifact("4394021")
//                            .prices(new HashSet<>())
//                            .build()
//            );
//
//            Answer answer1_1 = answerService.save(
//              Answer.builder()
//                      .answer("Нормальная")
//                      .products(Set.of(normalSkin))
//                      .build()
//            );
//
//            Answer answer1_2 = answerService.save(
//                    Answer.builder()
//                            .answer("Сухая")
//                            .products(Set.of(drySkin))
//                            .build()
//            );
//
//            Answer answer1_3 = answerService.save(
//                    Answer.builder()
//                            .answer("Комбинированная")
//                            .products(Set.of(combiSkin))
//                            .build()
//            );
//
////            Answer answer1_4 = answerService.save(
////                    Answer.builder()
////                            .answer("Жирная")
////                            .products(Set.of(normalSkin))
////                            .build()
////            );
//
//            Answer answer1_5 = answerService.save(
//                    Answer.builder()
//                            .answer("Чувствительная")
//                            .products(Set.of(sensitiveSkin))
//                            .build()
//            );
//
//            Survey survey1 = surveyService.save(
//              Survey.builder()
//                      .question("Какой у вас тип кожи:")
//                      .answers(List.of(answer1_1, answer1_2, answer1_3, answer1_5))
//                      .build()
//            );
//
////            sled
//
//            Answer answer2_1 = answerService.save(
//                    Answer.builder()
//                            .answer("Молодая")
//                            .products(Set.of(youngSkin))
//                            .build()
//            );
//
//            Answer answer2_2 = answerService.save(
//                    Answer.builder()
//                            .answer("Возрастная")
//                            .products(Set.of(oldSkin))
//                            .build()
//            );
//
//            Survey survey2 = surveyService.save(
//                    Survey.builder()
//                            .question("У Вас кожа:")
//                            .answers(List.of(answer2_1, answer2_2))
//                            .build()
//            );
//
////            sled
//
//            Answer answer3_1 = answerService.save(
//                    Answer.builder()
//                            .answer("Расширенные")
//                            .products(Set.of(extended))
//                            .build()
//            );
//
//            Answer answer3_2 = answerService.save(
//                    Answer.builder()
//                            .answer("Нормальные")
//                            .products(Set.of(normal))
//                            .build()
//            );
//
//            Survey survey3 = surveyService.save(
//                    Survey.builder()
//                            .question("Какие у вас поры:")
//                            .answers(List.of(answer3_1, answer3_2))
//                            .build()
//            );
//
//            Answer answer4_1 = answerService.save(
//                    Answer.builder()
//                            .answer("Да")
//                            .products(Set.of(with))
//                            .build()
//            );
//
//            Answer answer4_2 = answerService.save(
//                    Answer.builder()
//                            .answer("Нет")
//                            .products(Set.of(without))
//                            .build()
//            );
//
//            Survey survey4 = surveyService.save(
//                    Survey.builder()
//                            .question("Есть ли у вас акне?")
//                            .answers(List.of(answer4_1, answer4_2))
//                            .build()
//            );
//        };
//    }
}
