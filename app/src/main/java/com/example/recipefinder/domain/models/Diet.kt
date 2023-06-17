package com.example.recipefinder.domain.models

class Diet(
    val name: String,
    val ImageUrl: String
)
val dietsList = listOf<Diet>(

    Diet("Gluten Free", "https://www.hopkinsmedicine.org/-/media/images/health/3_-wellness/food-and-nutrition/gluten-free-diet-teaser.ashx"),
    Diet("Ketogenic", "https://www.eatingwell.com/thmb/OjqIt-0hf2URXH1LS9CakKOaiUQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/complete-keto-diet-food-list-what-you-can-and-cannot-eat-if-youre-on-a-ketogenic-diet-3-cd4cd1fc60cb455bbe7eee6e3a7d4d2c.jpg"),
    Diet("Vegetarian", "https://images.theconversation.com/files/352720/original/file-20200813-22-u6p0qo.jpg?ixlib=rb-1.1.0&rect=0%2C0%2C6576%2C4288&q=45&auto=format&w=926&fit=clip"),
    Diet("Lacto-Vegetarian", "https://upload.wikimedia.org/wikipedia/commons/e/e9/Soy-whey-protein-diet.jpg"),
    Diet("Ovo-Vegetarian", "https://s41230.pcdn.co/wp-content/uploads/2020/03/ovo-lacto-vegetarian-vegan-1.jpg"),
    Diet("Vegan", "https://images.everydayhealth.com/images/what-is-a-vegan-diet-benefits-food-list-beginners-guide-alt-1440x810.jpg?sfvrsn=1d260c85_1"),
    Diet("Pescetarian", "https://hips.hearstapps.com/hmg-prod/images/healthy-food-clean-eating-selection-royalty-free-image-854725402-1541080450.jpg"),
    Diet("Paleo", "https://health.clevelandclinic.org/wp-content/uploads/sites/3/2023/01/Paleo-Diet-1301565375-770x533-1.jpg"),
    Diet("Primal", "https://marksdailyapple.com/uploads/2008/07/Primal-diet.jpg"),
    Diet("Low FODMAP", "https://www.verywellfit.com/thmb/xdNGmNKfYdSOpV1bBnrOX0MwA1A=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/an-overview-of-the-low-fodmap-diet-4693610-a-75ff2a81cb314258b9eec65bad92c37f.jpg"),
    Diet("Whole30", "https://www.chiroeco.com/wp-content/uploads/2018/05/whole30.jpg"))