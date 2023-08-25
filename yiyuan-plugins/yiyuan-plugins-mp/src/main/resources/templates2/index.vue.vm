<template>
    <ManagePage :columns="columns" :data="data" :pagination="pagination" :renderObj="renderObj" @onSave="saveHandle"
                @onSubmit="submitHandle" @onDelete="deleteHandle" @onSearch="searchHandle" @onReset="resetHandle">

    </ManagePage>
</template>

<script>
    import ManagePage from "@/components/manage/ManagePage.vue";
    import manage from "@/mixins/manage";
    import {columns, moduleConfig} from "./pageConfig";

    export default {
        components: {
            ManagePage,
        },
        mixins: [manage()],
        data() {
            return {
                columns,
                ...moduleConfig,
            };
        },

        methods: {},
    }
</script>

<style lang="less" scoped></style>