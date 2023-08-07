package com.example.loginadmin_frank

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.editNicknameBtn
import kotlinx.android.synthetic.main.activity_main.loginBtn
import kotlinx.android.synthetic.main.activity_main.loginId
import kotlinx.android.synthetic.main.activity_main.loginPassword
import kotlinx.android.synthetic.main.activity_main.nicknameTxt

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1005
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNicknameBtn.setOnClickListener {


            val myIntent = Intent(this, EditNickname::class.java)
            startActivityForResult(myIntent, REQUEST_FOR_NICKNAME)

        }


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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        돌아온 이유가 닉네임을 받으러 다녀온게 맞는지??
        if (requestCode == REQUEST_FOR_NICKNAME) {

//            추가질문 : 확인을 눌러서 돌아온게 맞는가?

            if (resultCode == Activity.RESULT_OK) {
//                실제 첨부된 새 닉네임을 꺼내서 텍스트뷰 반영

                val newNickname = data?.getStringExtra("nickname")
                nicknameTxt.text = newNickname
            }
        }
    }
}