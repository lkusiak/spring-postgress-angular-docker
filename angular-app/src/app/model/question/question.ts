import { Answer } from '../answer/answer';

export class Question {
    id: number;
    category: string;
    subCategory: string;
    multiselect: boolean;
    text: string;
    explanation: string;
    answers: Array<Answer>;
}
