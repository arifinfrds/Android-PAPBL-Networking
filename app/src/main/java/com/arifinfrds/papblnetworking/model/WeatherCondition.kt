package com.arifinfrds.papblnetworking.model

/**
 * Created by arifinfrds on 3/11/18.
 */
class WeatherCondition {

    companion object {
        // var codeIcon: String, var imageUrl: String

        fun getWeatherIconUrl(codeIcon: String): String {
            var imageUrl = ""

            if (codeIcon.equals("01d")) {
                imageUrl = "https://images.unsplash.com/photo-1503453363464-743ee9ce1584?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=a0b180c432d9240da00e66807b834ffe&auto=format&fit=crop&w=1052&q=80"
            }
            if (codeIcon.equals("02d")) {
                imageUrl = "https://images.unsplash.com/photo-1513882913812-da41a726b866?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6e99480746462c9846e46247b108ef34&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("03d")) {
                imageUrl = "https://images.unsplash.com/photo-1497551407056-6fde78960ff7?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=60ea397874bf5dcda839fc9eefb3a57d&auto=format&fit=crop&w=1049&q=80"
            }
            if (codeIcon.equals("04d")) {
                imageUrl = "https://images.unsplash.com/photo-1432842078269-0049eb805253?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=cc0b3cdb03e45b29b139aad07cf5c082&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("09d")) {
                imageUrl = "https://images.unsplash.com/photo-1414395109488-785046246a20?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=ae0f2f1b68b5ef3336b734bc1fef7d47&auto=format&fit=crop&w=1055&q=80"
            }
            if (codeIcon.equals("10d")) {
                imageUrl = "https://images.unsplash.com/photo-1509041487337-74a81a42e9d8?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6ab44bdf519218449a090c4e7335ae13&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("11d")) {
                imageUrl = "https://images.unsplash.com/photo-1461511669078-d46bf351cd6e?ixlib=rb-0.3.5&s=593394fd4eb5ed915a9a0c113b2a5953&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("13d")) {
                imageUrl = "https://images.unsplash.com/photo-1452867789949-9167aed196b9?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=0354bd93b9b2638bc2dfa5b115e724a3&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("50d")) {
                imageUrl = "https://images.unsplash.com/photo-1464457312035-3d7d0e0c058e?ixlib=rb-0.3.5&s=436b59817d55fb3bcdf39677bdfa5204&auto=format&fit=crop&w=1050&q=80"
            }


            if (codeIcon.equals("01n")) {
                imageUrl = "https://images.unsplash.com/photo-1501504413881-5888acd06076?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=318f0ca9c243da6137a028112b6903ca&auto=format&fit=crop&w=1190&q=80"
            }
            if (codeIcon.equals("02n")) {
                imageUrl = "https://images.unsplash.com/photo-1488226941561-6d7a806ae42a?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=5f95cc79495c602f06dd3ba6b8219ed0&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("03n")) {
                imageUrl = "https://images.unsplash.com/photo-1504252060324-1c76e2e09939?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=71c57e3ab62925d3a62689cce328f0f8&auto=format&fit=crop&w=1049&q=80"
            }
            if (codeIcon.equals("04n")) {
                imageUrl = "https://images.unsplash.com/photo-1473667756246-477ca4048531?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=698c2c664d8beff2fa35ae3b774088ef&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("09n")) {
                imageUrl = "https://images.unsplash.com/photo-1438449805896-28a666819a20?ixlib=rb-0.3.5&s=9fd5228bbf23105ccd9b4e4f00246846&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("10n")) {
                imageUrl = "https://images.unsplash.com/photo-1509041487337-74a81a42e9d8?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6ab44bdf519218449a090c4e7335ae13&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("11n")) {
                imageUrl = "https://images.unsplash.com/photo-1516490981167-dc990a242afe?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=9de9c16971a6d2914d31d8236e7a46d2&auto=format&fit=crop&w=1050&q=80"
            }
            if (codeIcon.equals("13n")) {
                imageUrl = "https://images.unsplash.com/photo-1487924055077-1749be2afcca?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=7017b284b7c591c27ba5c58f312d3174&auto=format&fit=crop&w=1153&q=80"
            }
            if (codeIcon.equals("50n")) {
                imageUrl = "https://images.unsplash.com/photo-1464457312035-3d7d0e0c058e?ixlib=rb-0.3.5&s=436b59817d55fb3bcdf39677bdfa5204&auto=format&fit=crop&w=1050&q=80"
            }

            return imageUrl
        }
    }
}