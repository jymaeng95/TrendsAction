<template>
  <div class="wrapper">
    <Navbar />
    <Header />
    <section id="first-section" class="section-area">
      <v-container>
        <v-row class="section" justify="center" align="center">
          <v-col class="text-center" cols="12">
            <h2>TrendsAction</h2>
            <p>Get insight, and set the trend</p>
          </v-col>
          <v-col class="text-center" cols="12" md="4">
            <div class="trend-card" 
              data-sal="slide-up"
              data-sal-duration="800"
              data-sal-repeat>
                <v-img
                src="../assets/images/getinfo.jpg"
                style="border-radius:19px;"
                ></v-img>
                <div class="trend-card-info">
                  <h2 class="mb-3">STEP 1.</h2>
                  <p>트렌드 키워드에 따라, NEWS, SNS 다양한 트렌드 정보를 얻고, 사용자들과 자유롭게 의견을 공유하세요.</p>
                </div>
            </div>
          </v-col>
          <v-col class="text-center" cols="12" md="4">
            <div class="trend-card"
              data-sal="slide-up"
              data-sal-duration="800"
              data-sal-delay="500"
              data-sal-repeat>
                <v-img
                src="../assets/images/share.jpg"
                style="border-radius:19px;"
                ></v-img>
                <div class="trend-card-info">
                  <h2 class="mb-3">STEP 2.</h2>
                  <p>혹시 관련 프로젝트나 스터디를 진행 중인가요? 나만의 트렌드 보드에 담아 저장하고, 친구와 팀원과 공유가 가능합니다.</p>
                </div>
            </div>
          </v-col>
          <v-col class="text-center" cols="12" md="4">
            <div class="trend-card"
              data-sal="slide-up"
              data-sal-duration="800"
              data-sal-delay="800"
              data-sal-repeat>
              <v-img
                src="../assets/images/step3.jpg"
                style="border-radius:19px;"
                ></v-img>
              <div class="trend-card-info">
                <h2 class="mb-3">STEP 3.</h2>
                <p>최신 이슈들을 파악하고 트렌드를 예측해보세요. 당신의 트렌드는 무엇인가요?</p>
              </div>
            </div>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <section id="second-section" class="section-area">
      <div class="second-part">
        <div class="trendBx">
          <div>
            <h2>트렌드 키워드</h2>
            <input class="trendBx-btn" @click="$router.push({ name: $constants.URL_TYPE.TREND.LIST })" type="button" value="Learn more">
          </div>
        </div>
      
        <div class="predictBx">
          <div>
            <h2>예측 트렌드 키워드</h2>
            <input class="trendBx-btn" @click="$router.push({ name: 'PredictList' })" type="button" value="Learn more">
          </div>     
        </div>
      </div>
    </section>

    <section id="third-section" class="section-area my-16">
      <v-container class="my-16">
        <v-row justify="center">
          <v-col cols="12" lg="10">
            <h2 class="my-5">질문과 답변</h2>
            <v-expansion-panels focusable>
              <v-expansion-panel
                v-for="(faq,i) in faqs"
                :key="i"
              >
                <v-expansion-panel-header class="py-5">
                  <span>
                    <span style="font-size:1.5rem;"><i class="far fa-question-circle mr-3"></i></span>
                    <span style="font-size:1.2rem;">{{ faq.question }}</span>
                  </span>
                </v-expansion-panel-header>
                <v-expansion-panel-content class="pt-5">
                  {{ faq.answer }}
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
          </v-col>
        </v-row>
      </v-container>
    </section>
  </div>
</template>

<script>
import Navbar from '@/components/common/Navbar'
import Header from '@/components/common/Header'
import sal from "sal.js";

import { mapGetters } from 'vuex';
import axios from 'axios'
import SERVER from '@/lib/api'

export default {
  name: 'Home',
  components: {
    Header,
    Navbar,
  },
  data() {
    return {
      faqs: {},
    }
  },
  created() {
    this.getFaq()
  },
  computed: {
    ...mapGetters('userStore', ['isLogin', 'config'])
  },
  mounted() {
    sal();
  },
  methods: {
    getFaq() {
      axios
        .get(SERVER.URL + SERVER.ROUTES.boards.getFaq)
        .then((res) => { this.faqs = res.data.data })
        .catch((err) => { console.log(err)})
    }
  },
  
}
</script>

<style lang="scss" scoped>

.wrapper {
  position: relative;
}

.about {
  position: relative;
  width: 100%;
  display: flex;
  justify-content: center;
}


.section {
  padding: 5%;
  margin: 10% 0;
}

.trend-card {
  position:relative;
  width: 100%;
  min-height: 400px;
  padding: 3%;
  border-radius: 19px;
  background: #F5F5F6;
  box-shadow:  9px 9px 18px #ebebec, 
              -9px -9px 18px #ffffff;
}

.trend-card-img {
  position: relative;
  width: 100%;
  height: 40%;
  border-radius: 19px;
  background-image: url("../assets/images/getinfo.jpg");
  background-size: cover;
}

.trend-card-info {
  padding: 5%;
}


.trend-card:hover {
  border-radius: 19px;
  background: #F5F5F6;
  box-shadow:  9px 9px 18px #d0d0d1, 
              -9px -9px 18px #ffffff;
  transition: 0.4s;
}

.section-area {
  position: relative;
  width: 100%;
  // height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.section-area .arrow {
  position: absolute;
  bottom: 30px;
  left: 0;
  right: 0;
  text-align: center;
  cursor: pointer;
}

.second-part {
  position: relative;
  width: 100%;
  height: 600px;
  text-align: center;
  display: flex;
  align-items: center;
}

.second-part .trendBx {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  left: 0;
  height:100%;
  width: 50%;
  transition: 0.4s;
}

.trendBx {
  background-image: url('../assets/images/now.jpg');
  background-size: cover;
  color: #ffffff;
}

.trendBx:hover {
  background-color: #999999;
  transition: all .4s;
}

.second-part .predictBx {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  right: 0;
  height:100%;
  width: 50%;
  transition: 0.4s;
}

.predictBx {
  background-image: url('../assets/images/predict.jpg');
  background-size: cover;
  color: #ffffff;
}

.second-part .predictBx:hover {
  background-color:  #999999;
  transition: all .4s;
}

.trendBx-btn {
  margin-top: 20px;
  border: 2px solid #ffffff;
  border-radius: 30px;
  padding: 10px 20px;
  transition: .4s;
}

.trendBx-btn:hover {
  color: black;
  background-color: #ffffff;
  transition: .4s;
}

</style>