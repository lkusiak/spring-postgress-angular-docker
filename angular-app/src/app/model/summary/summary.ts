import { Answer } from '../answer/answer';

export class Summary {
    id: number;
    category: string;
    subCategory: string;
    multiSelect: boolean;
    text: string;
    explanation: string;
    correctAnswers: Array<Answer>;
    customerAnswers: Array<Answer>;
}
