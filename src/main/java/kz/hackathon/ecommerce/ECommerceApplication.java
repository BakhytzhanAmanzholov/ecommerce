package kz.hackathon.ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.hackathon.ecommerce.models.*;
import kz.hackathon.ecommerce.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @Bean
    public CommandLineRunner commandLineRunner(ProductService productService, SurveyService surveyService,
                                               AnswerService answerService, IngredientService ingredientService,
                                               CategoryService categoryService, SubCategoryService subCategoryService,
                                               AccountService accountService, PriceInfoService priceInfoService,
                                               CosmetologistInfoService cosmetologistInfoService, CosmetologistTimeService cosmetologistTimeService) {
        return args -> {
            Ingredient ingredient1 = ingredientService.save(
                Ingredient.builder()
                        .name("Ingredient 1")
                        .healthy(true)
                        .build()
            );
            Ingredient ingredient2 = ingredientService.save(
                    Ingredient.builder()
                            .name("Ingredient 2")
                            .healthy(true)
                            .build()
            );
            Ingredient ingredient3 = ingredientService.save(
                    Ingredient.builder()
                            .name("Ingredient 3")
                            .healthy(true)
                            .build()
            );
            Ingredient ingredient4 = ingredientService.save(
                    Ingredient.builder()
                            .name("Ingredient 4")
                            .healthy(false)
                            .build()
            );

            Set<Ingredient> ingredientSet = new HashSet<>();
            ingredientSet.add(ingredient1);
            ingredientSet.add(ingredient2);
            ingredientSet.add(ingredient3);
            ingredientSet.add(ingredient4);

            Product normalSkin = productService.save(
                    Product.builder()
                            .title("Clarins Multi Active Revitalizing Night cream")
                            .description("Ночной крем для нормальной и комбинированной кожи")
                            .artifact("285083")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Product drySkin = productService.save(
                    Product.builder()
                            .title("Edute Soon Jung Увлажняющий эмульсия")
                            .description("эмульсия для чувствительной и поврежденной кожи")
                            .artifact("470615")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Product combiSkin = productService.save(
                    Product.builder()
                            .title("CeraVe Moisturising cream")
                            .description("Увлажняющий крем Vanicream ™ восстанавливает и поддерживает нормальный уровень влажности. Он столь же нежен, сколь и эффективен даже для самой нежной кожи.")
                            .artifact("30016")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Product sensitiveSkin = productService.save(
                    Product.builder()
                            .title("Dr. Althea Resveratoral 345 NA Intensive Repair Cream")
                            .description("Восстанавливающий крем с ресвератролом сокращает выраженность мимических морщин и заметно разглаживает кожные заломы, ускоряет процессы регенерации и обновления кожи, повышает эластичность и укрепляет эпидермис.")
                            .artifact("00963")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

// след тест

            Product youngSkin = productService.save(
                    Product.builder()
                            .title("Lagom Cellus Mist Toner")
                            .description("Отличное средство для увлажнения, тонизирования и восстановления гидролипидного баланса эпидермиса.")
                            .artifact("544014")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Product oldSkin = productService.save(
                    Product.builder()
                            .title("Elemis Pro-Collagen Marine Cream")
                            .description("Крем для лица Морские водоросли Про-Коллаген")
                            .artifact("727")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

//            sled

            Product extended = productService.save(
                    Product.builder()
                            .title("Cosrx Full Fit")
                            .description("Легкий крем с экстрактом прополиса")
                            .artifact("45103")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Product normal = productService.save(
                    Product.builder()
                            .title("OLEHENRISKEN Truth Barier Booster Orange Ferment Vitamin C Essence")
                            .description("Улучшающая уход за кожей эссенция с витамином С")
                            .artifact("8809030312")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

//            sled

            Product without = productService.save(
                    Product.builder()
                            .title("Huggee All-in-one Cream")
                            .description("Универсальный крем для лица с лактобактериями HYGGEE All-In-One Cream активно увлажняет и питает кожу")
                            .artifact("8809030730312")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Product with = productService.save(
                    Product.builder()
                            .title("Farmacy 10% Waterless Vitamin C")
                            .description("Сыворотка с 10% витамином С, которая заметно осветляет")
                            .artifact("4394021")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Set<Product> productSet = new HashSet<>();
            productSet.add(normalSkin);
            Answer answer1_1 = answerService.save(
              Answer.builder()
                      .answer("Нормальная")
                      .products(productSet)
                      .build()
            );

            productSet.clear();
            productSet.add(drySkin);
            Answer answer1_2 = answerService.save(
                    Answer.builder()
                            .answer("Сухая")
                            .products(productSet)
                            .build()
            );

            productSet.clear();
            productSet.add(combiSkin);
            Answer answer1_3 = answerService.save(
                    Answer.builder()
                            .answer("Комбинированная")
                            .products(productSet)
                            .build()
            );

//            Answer answer1_4 = answerService.save(
//                    Answer.builder()
//                            .answer("Жирная")
//                            .products(Set.of(normalSkin))
//                            .build()
//            );
            productSet.clear();
            productSet.add(sensitiveSkin);
            Answer answer1_5 = answerService.save(
                    Answer.builder()
                            .answer("Чувствительная")
                            .products(productSet)
                            .build()
            );

            List<Answer> answerList = new ArrayList<>();
            answerList.add(answer1_1);
            answerList.add(answer1_2);
            answerList.add(answer1_3);
            answerList.add(answer1_5);

            Survey survey1 = surveyService.save(
              Survey.builder()
                      .question("Какой у вас тип кожи:")
                      .answers(answerList)
                      .build()
            );

//            sled
            productSet.clear();
            productSet.add(youngSkin);
            Answer answer2_1 = answerService.save(
                    Answer.builder()
                            .answer("Молодая")
                            .products(productSet)
                            .build()
            );

            productSet.clear();
            productSet.add(oldSkin);
            Answer answer2_2 = answerService.save(
                    Answer.builder()
                            .answer("Возрастная")
                            .products(productSet)
                            .build()
            );

            answerList.clear();
            answerList.add(answer2_1);
            answerList.add(answer2_2);
            Survey survey2 = surveyService.save(
                    Survey.builder()
                            .question("У Вас кожа:")
                            .answers(answerList)
                            .build()
            );

//            sled

            productSet.clear();
            productSet.add(extended);
            Answer answer3_1 = answerService.save(
                    Answer.builder()
                            .answer("Расширенные")
                            .products(productSet)
                            .build()
            );
            productSet.clear();
            productSet.add(normal);
            Answer answer3_2 = answerService.save(
                    Answer.builder()
                            .answer("Нормальные")
                            .products(productSet)
                            .build()
            );
            answerList.clear();
            answerList.add(answer3_1);
            answerList.add(answer3_2);
            Survey survey3 = surveyService.save(
                    Survey.builder()
                            .question("Какие у вас поры:")
                            .answers(answerList)
                            .build()
            );

            productSet.clear();
            productSet.add(with);
            Answer answer4_1 = answerService.save(
                    Answer.builder()
                            .answer("Да")
                            .products(productSet)
                            .build()
            );

            productSet.clear();
            productSet.add(without);
            Answer answer4_2 = answerService.save(
                    Answer.builder()
                            .answer("Нет")
                            .products(productSet)
                            .build()
            );
            answerList.clear();
            answerList.add(answer4_1);
            answerList.add(answer4_2);
            Survey survey4 = surveyService.save(
                    Survey.builder()
                            .question("Есть ли у вас акне?")
                            .answers(answerList)
                            .build()
            );

            Product tonal = productService.save(
                    Product.builder()
                            .title("Estee Lauder Double Wear")
                            .description("Превосходный тональный крем для активных женщин, который позволяет сделать быстрый, аккуратный и стойкий макияж")
                            .artifact("887167449091")
                            .prices(new HashSet<>())
                            .ingredients(ingredientSet)
                            .build()
            );

            Set<Product> productsForCategories = new HashSet<>();
            productsForCategories.add(tonal);
            SubCategory subCategory1 = subCategoryService.save(
                    SubCategory.builder()
                            .title("Тональные средства")
                            .products(productsForCategories)
                            .build()
            );

            Set<SubCategory> subCategorySet = new HashSet<>();
            subCategorySet.add(subCategory1);
            Category category1 = categoryService.save(
                    Category.builder()
                            .title("Декоративная косметика")
                            .subCategories(subCategorySet)
                            .build()
            );
            productsForCategories.clear();
            productsForCategories.add(normalSkin);
            productsForCategories.add(drySkin);
            productsForCategories.add(combiSkin);
            productsForCategories.add(sensitiveSkin);
            productsForCategories.add(oldSkin);
            productsForCategories.add(extended);
            productsForCategories.add(without);
            SubCategory subCategory2 = subCategoryService.save(
                    SubCategory.builder()
                            .title("Кремы")
                            .products(productsForCategories)
                            .build()
            );
            productsForCategories.clear();
            productsForCategories.add(youngSkin);
            SubCategory subCategory3 = subCategoryService.save(
                    SubCategory.builder()
                            .title("Тонеры")
                            .products(productsForCategories)
                            .build()
            );
            productsForCategories.clear();
            productsForCategories.add(normal);
            productsForCategories.add(with);
            SubCategory subCategory4 = subCategoryService.save(
                    SubCategory.builder()
                            .title("Сыворотки")
                            .products(productsForCategories)
                            .build()
            );
            subCategorySet.clear();
            subCategorySet.add(subCategory4);
            subCategorySet.add(subCategory3);
            subCategorySet.add(subCategory2);

            Category category2 = categoryService.save(
                    Category.builder()
                            .title("Уходовая косметика")
                            .subCategories(subCategorySet)
                            .build()
            );
            Category category3 = categoryService.save(
                    Category.builder()
                            .title("Парфюмерия")
                            .subCategories(new HashSet<>())
                            .build()
            );


            productService.updateSubCategory(subCategory1, tonal);
            productService.updateCategory(category1, tonal);

            productService.updateSubCategory(subCategory2, normalSkin);
            productService.updateCategory(category2, normalSkin);

            productService.updateSubCategory(subCategory2, sensitiveSkin);
            productService.updateCategory(category2, sensitiveSkin);

            productService.updateSubCategory(subCategory2, combiSkin);
            productService.updateCategory(category2, combiSkin);

            productService.updateSubCategory(subCategory2, without);
            productService.updateCategory(category2, without);

            productService.updateSubCategory(subCategory2, extended);
            productService.updateCategory(category2, extended);

            productService.updateSubCategory(subCategory2, oldSkin);
            productService.updateCategory(category2, oldSkin);

            productService.updateSubCategory(subCategory2, drySkin);
            productService.updateCategory(category2, drySkin);

            productService.updateSubCategory(subCategory4, with);
            productService.updateCategory(category2, with);

            productService.updateSubCategory(subCategory4, normal);
            productService.updateCategory(category2, normal);

            productService.updateSubCategory(subCategory3, youngSkin);
            productService.updateCategory(category2, youngSkin);

            Account accountSeller1 = accountService.save(
              Account.builder()
                      .preferencesProducts(new HashSet<>())
                      .role(Account.Role.SELLER)
                      .email("seller@gmail.com")
                      .name("Monamie")
                      .password("abc123")
                      .surname("")
                      .build()
            );
            Account account = accountService.save(
                    Account.builder()
                            .preferencesProducts(new HashSet<>())
                            .role(Account.Role.USER)
                            .subscription(Account.Subscription.ENABLED)
                            .email("user@gmail.com")
                            .name("Bakhytzhan")
                            .password("abc123")
                            .surname("Amanzholov")
                            .banned(true)
                            .confirmed(true)
                            .build()
            );

            PriceInfo priceInfo1 = priceInfoService.save(
              PriceInfo.builder()
                      .price(5000)
                      .delivery("3-5 Ноября")
                      .build()
            );
            accountService.addPriceInfoToAccount(accountSeller1, priceInfo1);
            productService.addPriceInfoToProduct(normalSkin, priceInfo1);

            productService.purchaseProduct(account, accountSeller1, normalSkin, priceInfo1);

            PriceInfo priceInfo2 = priceInfoService.save(
                    PriceInfo.builder()
                            .price(15000)
                            .delivery("3-4 Ноября")
                            .build()
            );
            accountService.addPriceInfoToAccount(accountSeller1, priceInfo2);
            productService.addPriceInfoToProduct(normal, priceInfo2);

            PriceInfo priceInfo3 = priceInfoService.save(
                    PriceInfo.builder()
                            .price(10000)
                            .delivery("3-6 Ноября")
                            .build()
            );
            accountService.addPriceInfoToAccount(accountSeller1, priceInfo3);
            productService.addPriceInfoToProduct(drySkin, priceInfo3);

            PriceInfo priceInfo4 = priceInfoService.save(
                    PriceInfo.builder()
                            .price(70000)
                            .delivery("3-9 Ноября")
                            .build()
            );
            accountService.addPriceInfoToAccount(accountSeller1, priceInfo4);
            productService.addPriceInfoToProduct(sensitiveSkin, priceInfo4);

            Account cosmetologist1 = accountService.save(
                    Account.builder()
                            .subscription(Account.Subscription.COSMETOLOGIST)
                            .name("Aidana")
                            .role(Account.Role.COSMETOLOGIST)
                            .email("aidana.cosmetologist@gmail.com")
                            .surname("Malieva")
                            .password("abc123")
                            .cosmetologistInfos(new ArrayList<>())
                            .build()
            );

            Account cosmetologist2 = accountService.save(
                    Account.builder()
                            .subscription(Account.Subscription.COSMETOLOGIST)
                            .name("Madina")
                            .role(Account.Role.COSMETOLOGIST)
                            .email("madina.cosmetologist@gmail.com")
                            .surname("Lobaueva")
                            .password("abc123")
                            .build()
            );

            CosmetologistInfo cosmetologistInfo1 = cosmetologistInfoService.save(
                    CosmetologistInfo.builder()
                            .cosmetologist(cosmetologist1)
                            .state(CosmetologistInfo.Sphere.Cosmetologist)
                            .times(new ArrayList<>())
                            .price(5000)
                            .build()
            );

            CosmetologistInfo cosmetologistInfo2 = cosmetologistInfoService.save(
                    CosmetologistInfo.builder()
                            .cosmetologist(cosmetologist1)
                            .state(CosmetologistInfo.Sphere.Dermatologist)
                            .times(new ArrayList<>())
                            .price(15000)
                            .build()
            );

            CosmetologistTime cosmetologistTime1 = cosmetologistTimeService.save(
              CosmetologistTime.builder()
                      .time(Time.valueOf(LocalTime.now()))
                      .account(account)
                      .cosmetologist(cosmetologist1)
                      .build()
            );

            CosmetologistTime cosmetologistTime2 = cosmetologistTimeService.save(
                    CosmetologistTime.builder()
                            .time(Time.valueOf(LocalTime.now()))
                            .cosmetologist(cosmetologist1)
                            .build()
            );

            CosmetologistTime cosmetologistTime3 = cosmetologistTimeService.save(
                    CosmetologistTime.builder()
                            .time(Time.valueOf(LocalTime.now()))
                            .account(account)
                            .cosmetologist(cosmetologist1)
                            .build()
            );

            CosmetologistTime cosmetologistTime4 = cosmetologistTimeService.save(
                    CosmetologistTime.builder()
                            .time(Time.valueOf(LocalTime.now()))
                            .cosmetologist(cosmetologist1)
                            .build()
            );

            CosmetologistTime cosmetologistTime5 = cosmetologistTimeService.save(
                    CosmetologistTime.builder()
                            .time(Time.valueOf(LocalTime.now()))
                            .cosmetologist(cosmetologist1)
                            .build()
            );
            accountService.addInfoToCosmetologist(cosmetologist1, cosmetologistInfo1);
            accountService.addInfoToCosmetologist(cosmetologist1, cosmetologistInfo2);

            cosmetologistInfoService.addTimeToInfo(cosmetologistInfo1, cosmetologistTime1);
            cosmetologistInfoService.addTimeToInfo(cosmetologistInfo1, cosmetologistTime2);
            cosmetologistInfoService.addTimeToInfo(cosmetologistInfo1, cosmetologistTime3);
            cosmetologistInfoService.addTimeToInfo(cosmetologistInfo2, cosmetologistTime4);
            cosmetologistInfoService.addTimeToInfo(cosmetologistInfo2, cosmetologistTime5);



        };
    }

}
