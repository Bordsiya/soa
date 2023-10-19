import { createRouter, createWebHashHistory } from 'vue-router';
import First from "@/components/First.vue";
import Second from "@/components/Second.vue";
import Third from "@/components/Third.vue";

export default createRouter({
    history: createWebHashHistory(),

    routes: [
        { path: '/first', component: First, alias: "/" },
        { path: '/second', component: Second },
        { path: '/third', component: Third },
    ]

})