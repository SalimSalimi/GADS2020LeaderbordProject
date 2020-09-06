package dz.salim.salimi.gadsleaderbordproject.data.retrofit

import dz.salim.salimi.gadsleaderbordproject.utils.*
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface FormApiService {

    @POST(FORM_ID)
    @FormUrlEncoded
    suspend fun submitForm (
        @Field(EMAIL_ENCODED_FIELD) email: String,
        @Field(NAME_ENCODED_FIELD) name: String,
        @Field(LAST_NAME_ENCODED_FIELD) lastName: String,
        @Field(GITHUB_LINK_ENCODED_FIELD) githubLink: String
    ): Response<Void>
}