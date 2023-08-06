package com.example.loginadmin_frank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.loginBtn
import kotlinx.android.synthetic.main.activity_main.loginId
import kotlinx.android.synthetic.main.activity_main.loginPassword

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginBtn.setOnClickListener {

            val inputID = loginId.text.toString()
            val inputPW = loginPassword.text.toString()

            if (inputID == "admin@test.com" && inputPW == "qwer")  {

                // 둘다 맞다면 "관리자가 맞습니다. 라는 문구를 띄워준다
                Toast.makeText(this, "관리자입니다.", Toast.LENGTH_SHORT). show()
            }
            else {
                // 아이디/비번 중 하나라도 틀리면 로그인 실패 토스트
                Toast.makeText(this, "로그인 실패입니다.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}